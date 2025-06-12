package com.example.quizz_master

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizz_master.screens.EndScreen
import com.example.quizz_master.screens.QuestionScreen
import com.example.quizz_master.screens.StartingScreen

@Composable
fun Navigation(questions: MutableList<Question>) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "startingScreen") {
        composable("startingScreen") {
            StartingScreen(
                onStartClick = {
                    navController.navigate("questionScreen")
                }
            )
        }

        composable("questionScreen") {
            QuestionScreen(
                questions = questions
                // Kein onGameFinished callback hier
            )
        }

        composable("endScreen") {
            EndScreen(
                score = 0, // Falls du Score später anders übergeben willst, musst du es manuell anpassen
                totalQuestions = 30,
                onRestartClick = {
                    navController.navigate("startingScreen") {
                        popUpTo("startingScreen") { inclusive = true }
                    }
                }
            )
        }
    }
}


