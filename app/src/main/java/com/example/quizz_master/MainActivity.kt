package com.example.quizz_master

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import com.example.quizz_master.screens.QuestionScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val questions = loadQuestions(this)
        setContent {
            QuestionScreen(questions)
        }
    }
}

//Farben
val myBlue = Color.hsv(196f, 1f, 1f)
val myDarkBlue = Color.hsv(200f, 1f, 0.75f)
val myOrange = Color.hsv(35f, 1f, 1f)

//Preview
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    val demoQuestion = Question(
        1,
        "Was ist die Hauptstadt von Australien?",
        listOf(
            Answer("Canberra", true),
            Answer("Sydney", false),
            Answer("Melbourne", false)
        )
    )
    val demoQuestions = mutableListOf(demoQuestion)
    QuestionScreen(demoQuestions)
}