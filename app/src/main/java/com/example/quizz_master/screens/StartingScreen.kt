package com.example.quizz_master.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizz_master.myBlue
import com.example.quizz_master.myOrange

@Composable
fun StartingScreen(onStartClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(myBlue),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Willkommen zum Quiz!",
                fontSize = 28.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            Button(
                onClick = onStartClick,
                colors = ButtonDefaults.buttonColors(containerColor = myOrange),
                modifier = Modifier
                    .width(220.dp)
                    .height(60.dp)
            ) {
                Text(
                    text = "Quiz starten",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
}

