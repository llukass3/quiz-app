package com.example.quizz_master.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizz_master.Answer
import com.example.quizz_master.Question
import com.example.quizz_master.R
import com.example.quizz_master.myBlue
import com.example.quizz_master.myDarkBlue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*Der Hauptteil des Spiels. Diese Funktion bekommt eine Liste an Fragen übergeben und
* konstruiert die UI*/
@Composable
fun QuestionScreen(questions: MutableList<Question>) {

    //die Anzahl an bereits beantworteten Fragen
    val questionCount = remember { mutableIntStateOf(1) }

    //die angezeigte Frage
    val currentQuestion = remember { mutableStateOf(questions[questions.indices.random()]) }

    //die Anzahl an richtig beantworteten Fragen
    val score = remember { mutableIntStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Header(score.intValue) //zeige den score im Header an
        DisplayQuestion(
            currentQuestion.value, //zeige die aktuelle Frage an

            //callback funktion wird ausgeführt, wenn eine Frage beantwortet wird
            onAnswered = {
                //erhöhe den Fragezähler um 1
                questionCount.intValue++
                //entferne die letzte beantwortete Frage aus der Liste um dopplungen zu vermeiden
                questions.remove(currentQuestion.value)
                //wähle eine neue, zufällige Frage aus der Liste aus
                currentQuestion.value = questions[questions.indices.random()]
            },

            //wird zusätzlich ausgeführt, wenn eine Frage korrekt beantwortet wird
            onCorrectAnswer = {
                //erhöhe den score um 1
                score.intValue++
            }
        )
        Footer(questionCount) //zeigt an, wie viele Fragen beantwortet wurden
    }
}

/*diese Funktion bekommt eine Frage übergeben und baut das entsprechende UI für sie.
* eine callback funktion wird ausgeführt, wenn eine Frage beantwortet wird*/
@Composable
fun DisplayQuestion(
    question: Question,
    onAnswered: () -> Unit,
    onCorrectAnswer: () -> Unit
) {
    val selectedAnswer = remember { mutableStateOf<Answer?>(null) }
    val isAnswered = remember { mutableStateOf(false) }

    // Needed for launching the delay
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(400.dp)
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Text(
            question.question,
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 30.dp)
        )

        Column {
            for (answer: Answer in question.answers) {
                // Determine button color
                val buttonColor = when {
                    !isAnswered.value -> myBlue
                    selectedAnswer.value == answer && answer.isCorrect -> Color.Green
                    selectedAnswer.value == answer && !answer.isCorrect -> Color.Red
                    else -> myBlue
                }

                Button(
                    onClick = {
                        if (!isAnswered.value) {
                            selectedAnswer.value = answer
                            isAnswered.value = true
                            if (answer.isCorrect) {
                                onCorrectAnswer()
                            }

                            scope.launch {
                                delay(1000L) // wait 1 second
                                onAnswered() // next question
                                selectedAnswer.value = null
                                isAnswered.value = false
                            }
                        }
                    },
                    colors = buttonColors(
                        containerColor = buttonColor
                    ),
                    modifier = Modifier
                        .width(300.dp)
                        .height(60.dp)
                        .padding(bottom = 10.dp)
                ) {
                    Text(
                        answer.answer,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

//Header mit Logo und Score
@Composable
fun Header(score: Int) {
    Column {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(myBlue)
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.padding(top = 30.dp)
            )
        }
        Score(score)
    }
}

//Footer mit Fragenzähler
@Composable
fun Footer(questionCount: MutableIntState) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(myDarkBlue)
    ) {
        Text(
            "Frage ${questionCount.intValue} von 30",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 47.dp)
        ) }
}

//Score, zeigt die Anzahl richtig beantworteter Fragen an
@Composable
fun Score(score: Int) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .background(myDarkBlue)
    ) {
        Text(
            "SCORE: $score",
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}