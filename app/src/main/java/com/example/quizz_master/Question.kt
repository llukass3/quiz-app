package com.example.quizz_master

import kotlinx.serialization.*
import android.content.Context
import android.util.Log
import kotlinx.serialization.json.Json
import java.io.IOException

//Data class representing a question
@Serializable
data class Question(
    val id: Int,
    val question: String,
    val answers: List<Answer>
)

//Data class representing an answer
@Serializable
data class Answer(
    val answer: String,
    val isCorrect: Boolean
)

//function that loads json data
fun loadQuestions(context: Context): List<Question> {
    return try {
        val json = context.assets.open("questions.json")
            .bufferedReader()
            .use { it.readText() }

        Json.decodeFromString(json)

    } catch (e: IOException) {
        Log.e("QuizLoader", "Error reading from assets", e)
        emptyList()
    } catch (e: SerializationException) {
        Log.e("QuizLoader", "Error parsing JSON", e)
        emptyList()
    }
}


