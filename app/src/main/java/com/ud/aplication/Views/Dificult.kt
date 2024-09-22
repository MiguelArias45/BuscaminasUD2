package com.ud.aplication.Views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DificultadScreen(onStartGame: (Int, Int, Int) -> Unit) {
    var selectedDifficulty by remember { mutableStateOf("fácil") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Selecciona la Dificultad")

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedDifficulty == "fácil",
                onClick = {
                    selectedDifficulty = "fácil"
                    onStartGame(8, 8, 10) // Fila, columna, minas
                }
            )
            Text("Fácil")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedDifficulty == "intermedio",
                onClick = {
                    selectedDifficulty = "intermedio"
                    onStartGame(16, 16, 40) // Fila, columna, minas
                }
            )
            Text("Intermedio")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedDifficulty == "difícil",
                onClick = {
                    selectedDifficulty = "difícil"
                    onStartGame(24, 24, 99) // Fila, columna, minas
                }
            )
            Text("Difícil")
        }
    }
}
