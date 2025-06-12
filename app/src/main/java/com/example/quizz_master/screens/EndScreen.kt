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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizz_master.myBlue
import com.example.quizz_master.myDarkBlue
import com.example.quizz_master.myOrange

@Composable
fun EndScreen(score: Int, totalQuestions: Int, onRestartClick: () -> Unit) {
    val percentage = (score * 100) / totalQuestions
    val message = when {
        percentage >= 90 -> "Du hast es geschafft!\nDein Allgemeinwissen ist mega! 🎉"
        percentage >= 70 -> "Gut gemacht!\nEin bisschen fehlt noch!"
        else -> "Versuch es nochmal!\nDu kannst das besser!"
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(myBlue),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Quiz beendet!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Text(
                text = "Dein Score: $score / $totalQuestions",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Text(
                text = message,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 40.dp),
                lineHeight = 28.sp
            )
            Button(
                onClick = onRestartClick,
                colors = ButtonDefaults.buttonColors(containerColor = myOrange),
                modifier = Modifier
                    .width(220.dp)
                    .height(60.dp)
            ) {
                Text(
                    text = "Nochmal spielen",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}
