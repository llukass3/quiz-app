package com.example.quizz_master

import kotlinx.serialization.*
import android.content.Context
import android.util.Log
import kotlinx.serialization.json.Json
import java.io.IOException

//Diese Datenklasse repräsentiert eine Frage
@Serializable
data class Question(
    val id: Int,
    val question: String,
    val answers: List<Answer>
)

//Diese Datenklasse repräsentiert eine Antwort
@Serializable
data class Answer(
    val answer: String,
    val isCorrect: Boolean
)

//Funktion um die Fragen aus einer JSON-Datei auszulesen und zu deserialisieren
fun loadQuestions(context: Context): MutableList<Question> {
    return try {
        val json = context.assets.open("questions.json")
            .bufferedReader()
            .use { it.readText() }

        Json.decodeFromString(json)

    } catch (e: IOException) {
        Log.e("QuizLoader", "Error reading from assets", e)
        mutableListOf()
    } catch (e: SerializationException) {
        Log.e("QuizLoader", "Error parsing JSON", e)
        mutableListOf()
    }
}
