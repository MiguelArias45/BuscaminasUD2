package com.ud.aplication.Views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultScreen(hasWon: Boolean, onPlayAgain: () -> Unit, onReturnToMenu: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = if (hasWon) "¡Has ganado!" else "¡Has perdido!")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onPlayAgain) {
            Text("Jugar de nuevo")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onReturnToMenu) {
            Text("Volver al Menú")
        }
    }
}
