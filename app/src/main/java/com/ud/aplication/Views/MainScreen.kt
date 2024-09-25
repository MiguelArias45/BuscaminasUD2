package com.ud.aplication.Views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DificultadScreen(onStartGame: (Int, Int, Int) -> Unit) {
    var selectedDifficulty by remember { mutableStateOf("fácil") }

    // Fondo claro para la pantalla
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECEFF1)) // Color claro de fondo
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .border(BorderStroke(2.dp, Color(0xFF90CAF9)), RoundedCornerShape(8.dp)) // Contorno azul claro
                .padding(16.dp), // Espaciado interno
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Mensaje de bienvenida
            Text(
                text = "BIENVENIDOS A BUSCAMINASUD",
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp), // Ajusta el tamaño del texto
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color(0xFF42A5F5)) // Fondo azul
                    .fillMaxWidth() // Ocupa todo el ancho
                    .padding(16.dp), // Espacio interno del recuadro
                color = Color.White, // Color del texto
                textAlign = TextAlign.Center // Centrar texto
            )

            Spacer(modifier = Modifier.height(32.dp)) // Espacio entre el mensaje y las opciones

            // Título de selección de dificultad
            Text(
                text = "SELECCIONA LA DIFICULTAD",
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp), // Aumenta el tamaño del texto
                modifier = Modifier.padding(vertical = 8.dp) // Espaciado vertical
            )

            Spacer(modifier = Modifier.height(16.dp)) // Espacio entre el título y las opciones

            // Opciones de dificultad
            Column {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 4.dp)) {
                    RadioButton(
                        selected = selectedDifficulty == "fácil",
                        onClick = {
                            selectedDifficulty = "fácil"
                            onStartGame(8, 8, 10) // Fila, columna, minas
                        },
                        colors = RadioButtonDefaults.colors(selectedColor = Color.Blue) // Color del radio button
                    )
                    Text("Fácil", fontSize = 18.sp) // Aumenta el tamaño del texto
                }

                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 4.dp)) {
                    RadioButton(
                        selected = selectedDifficulty == "intermedio",
                        onClick = {
                            selectedDifficulty = "intermedio"
                            onStartGame(16, 16, 40) // Fila, columna, minas
                        },
                        colors = RadioButtonDefaults.colors(selectedColor = Color.Blue) // Color del radio button
                    )
                    Text("Intermedio", fontSize = 18.sp) // Aumenta el tamaño del texto
                }

                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 4.dp)) {
                    RadioButton(
                        selected = selectedDifficulty == "difícil",
                        onClick = {
                            selectedDifficulty = "difícil"
                            onStartGame(24, 24, 99) // Fila, columna, minas
                        },
                        colors = RadioButtonDefaults.colors(selectedColor = Color.Blue) // Color del radio button
                    )
                    Text("Difícil", fontSize = 18.sp) // Aumenta el tamaño del texto
                }
            }
        }
    }
}
