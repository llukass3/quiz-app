package com.example.quizz_master
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DisplayQuestionScreen(questions: List<Question>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Header()
        DisplayQuestion(questions[2])
        Footer(3)
    }
}

@Composable
fun DisplayQuestion(question: Question) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(400.dp)
            .padding(start = 20.dp, end = 20.dp)
    ){
        Text(
            question.question,
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 30.dp)
        )
        Column {
            for(answer: Answer in question.answers) {
                Button(
                    onClick = {},
                    colors = buttonColors(
                        containerColor = myBlue
                    ),
                    modifier = Modifier
                        .width(300.dp)
                        .height(60.dp)
                        .padding(bottom = 10.dp)
                ) {
                    Text(
                    answer.answer,
                    fontSize = 18.sp,)
                }
            }
        }
    }
}

@Composable
fun Header() {
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
        Score(3)
    }
}

@Composable
fun Footer(questionCount: Int) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(myDarkBlue)
    ) {
        Text(
            "Frage $questionCount von 30",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 47.dp)
        ) }
}

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