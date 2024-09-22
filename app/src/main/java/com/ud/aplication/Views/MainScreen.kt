package com.ud.aplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import com.ud.aplication.Views.DificultadScreen
import com.ud.aplication.Views.GameScreen
import com.ud.aplication.Views.ResultScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent() {
    var gameState by remember { mutableStateOf("menu") }
    var gameParameters by remember { mutableStateOf(Triple(10, 10, 10)) } // Fila, Columna, Minas

    when (gameState) {
        "menu" -> DificultadScreen { f, c, m ->
            gameParameters = Triple(f, c, m)
            gameState = "game"
        }
        "game" -> GameScreen(gameParameters.first, gameParameters.second, gameParameters.third) { hasWon ->
            gameState = "result"
        }
        "result" -> ResultScreen(hasWon = true, onPlayAgain = { gameState = "game" }, onReturnToMenu = { gameState = "menu" })
    }
}
