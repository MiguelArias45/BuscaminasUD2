package com.ud.aplication.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ud.aplication.Logic.Casilla
import com.ud.aplication.Logic.Tablero
import com.ud.aplication.Logic.Operaciones
import androidx.compose.material3.Text
import androidx.compose.foundation.ExperimentalFoundationApi

@OptIn(ExperimentalFoundationApi::class) // Anotación para la API experimental
@Composable
fun GameScreen(f: Int, c: Int, m: Int, onGameEnd: (Boolean) -> Unit) {
    var tablero = remember { Tablero.getTablero(f, c, m) }
    var isGameOver by remember { mutableStateOf(false) }

    // Ajustar el tamaño de las casillas según la dificultad
    val cellSize = when (f) {
        8 -> 40.dp // Tamaño para fácil
        16 -> 35.dp // Tamaño para intermedio
        24 -> 30.dp // Tamaño para difícil
        else -> 40.dp // Tamaño por defecto
    }

    // Usar un Box para centrar el contenido vertical y horizontalmente
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center // Centrar vertical y horizontalmente
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally // Centrar las filas
        ) {
            for (row in tablero.indices) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center // Alinear columnas al centro
                ) {
                    for (col in tablero[row].indices) {
                        val casilla = tablero[row][col]

                        Box(
                            modifier = Modifier
                                .size(cellSize)
                                .background(Color.LightGray) // Color de fondo gris claro
                                .border(1.dp, Color.Black) // Contorno negro uniforme
                                .combinedClickable(
                                    onClick = {
                                        if (isGameOver) return@combinedClickable
                                        when (casilla.getEstado()) {
                                            "oculta" -> {
                                                if (casilla.getValor() == 100) {
                                                    Operaciones.mostrarMinas(tablero)
                                                    isGameOver = true
                                                    onGameEnd(false) // Fin del juego por mina
                                                } else {
                                                    if (casilla.getValor() == 0) {
                                                        Operaciones.mostrarCerosAdyacentes(row, col, tablero)
                                                    }
                                                    casilla.setEstado("levantada")
                                                }
                                            }
                                        }
                                    },
                                    onLongClick = {
                                        if (isGameOver) return@combinedClickable
                                        if (casilla.getEstado() == "oculta") {
                                            casilla.setEstado("marcada") // Cambia el estado a marcada
                                        }
                                    }
                                )
                        ) {
                            val displayText = when (casilla.getEstado()) {
                                "levantada" -> {
                                    if (casilla.getValor() == 100) {
                                        "💣" // Emoji para la mina
                                    } else {
                                        casilla.getValor().toString() // Mostrar valor cuando está levantada
                                    }
                                }
                                "marcada" -> "🚩" // Emoji para la bandera
                                else -> "" // Casilla oculta sin texto
                            }
                            Text(
                                text = displayText,
                                fontSize = 16.sp,
                                color = Color.Black,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }
}
