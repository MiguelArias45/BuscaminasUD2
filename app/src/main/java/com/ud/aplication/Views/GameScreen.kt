package com.ud.aplication.Views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ud.aplication.Logic.Tablero
import com.ud.aplication.Logic.Casilla
import com.ud.aplication.Logic.Operaciones

@Composable
fun GameScreen(f: Int, c: Int, m: Int, onGameEnd: (Boolean) -> Unit) {
    val tablero = remember { Tablero.getTablero(f, c, m) }
    var gameOver by remember { mutableStateOf(false) }
    var gameWon by remember { mutableStateOf(false) }

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
                            if (casilla.getEstado() == "oculta") {
                                if (casilla.getValor() == 100) {
                                    gameOver = true
                                    Operaciones.mostrarMinas(tablero)
                                    onGameEnd(false)
                                } else {
                                    if (casilla.getValor() == 0) {
                                        Operaciones.mostrarCerosAdyacentes(row, col, tablero)
                                    }
                                    if (checkWinCondition(tablero)) {
                                        gameWon = true
                                        onGameEnd(true)
                                    }
                                }
                            }
                        }
                    ) {
                        BasicText(text = when {
                            gameOver -> if (casilla.getValor() == 100) "💣" else casilla.getValor().toString()
                            else -> casilla.getEstado()
                        })
                    }
                }
            }
        }
    }
}

fun checkWinCondition(tablero: Array<Array<Casilla>>): Boolean {
    for (row in tablero) {
        for (casilla in row) {
            if (casilla.getEstado() == "oculta" && casilla.getValor() != 100) {
                return false
            }
        }
    }
    return true
}
