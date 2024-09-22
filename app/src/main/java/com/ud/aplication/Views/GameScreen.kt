package com.ud.aplication.vistas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ud.aplication.Logic.Casilla
import com.ud.aplication.Logic.Tablero
import com.ud.aplication.Logic.Operaciones

@Composable
fun GameScreen(f: Int, c: Int, m: Int, onGameEnd: (Boolean) -> Unit) {
    var tablero = remember { Tablero.getTablero(f, c, m) }
    var isGameOver by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (row in tablero.indices) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                for (col in tablero[row].indices) {
                    val casilla = tablero[row][col]
                    Button(
                        modifier = Modifier.size(40.dp),
                        onClick = {
                            if (isGameOver) return@Button
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
                            if (isGameOver) return@Button
                            if (casilla.getEstado() == "oculta") {
                                casilla.setEstado("marcada") // Cambia el estado a marcada
                            }
                        }
                    ) {
                        val displayText = when (casilla.getEstado()) {
                            "levantada" -> casilla.getValor().toString()
                            "marcada" -> "🚩" // Emoji para la bandera
                            else -> "?" // Casilla oculta
                        }
                        BasicText(text = displayText)
                    }
                }
            }
        }
    }
}
