package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.quizapp.ui.theme.QuizAppTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Card
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        setContent {
            QuizAppTheme {
                   HomePage()
                }
            }
        }
    }





val questions = listOf(
    Question("Rice fixes water damage on phones",false),
    Question("Charging your phone overnight will damage the battery",false),
    Question("Cold water can help help reduce swelling minor injuries",true),
    Question("Eating carrots will dramatically improve your eyesight",false),
    Question("Turning off lights when not in use saves electricity",true),
    Question("Regular hand washing helps prevent the spread of illness",true),
    Question("Stretching immediately after waking up can reduce stiffness",true),
    Question("Using a fan in a closed room lowers the room temperature",false),
    Question("Placing a spoon in a bottle of champagne keeps it fizzy",false),
    Question("Drinking water helps improves concentration",true)
)
@Composable
fun HomePage() {
    var startQuiz by remember { mutableStateOf(false) }

    if (!startQuiz){
        Column(
            modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(colors = listOf(Color(0xFFE3F2FD),Color(0xFFBBDEFB)))).statusBarsPadding().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
            text = "Life Hack or Myth?"

        )
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier.fillMaxWidth(1f),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ){
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text ="Life hacks and internet rumours are everywhere. Users often struggle to distinguish between genuine productivity tips and urban myths that have gone viral." +
                                "This app provides a 'Life Hack or Urban Myth?' flashcard game to help users test their common sense and learn useful (and safe) real-world shortcuts."

                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { startQuiz = true},
                shape = RoundedCornerShape(12.dp)
            ){
                Text("Start Quiz")
            }
        }
    } else {
        QuizApp()
    }
}
@Composable
fun QuizApp() {
    var index by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var feedback by remember { mutableStateOf("") }
    var answered by remember { mutableStateOf(false) }
    var showResults by remember { mutableStateOf(false) }
    var reviewMode by remember { mutableStateOf(false) }

    if (reviewMode) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFE3F2FD),
                            Color(0xFFBBDEFB)
                        )
                    )
                ).verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "Review Answers",
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            questions.forEach { q ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                ) {

                    Column(modifier = Modifier.padding(16.dp)) {

                        // QUESTION
                        Text(
                            text = q.text,
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // CORRECT ANSWER
                        Text(
                            text = "Correct Answer: ${if (q.answer) "True" else "Myth"}",
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    reviewMode = false
                    showResults = true
                }
            ) {
                Text("Back")
            }
        }

    }

    else if (showResults) {

        //RESULT SCREEN
        Column(
            Modifier.fillMaxSize().background(Brush.verticalGradient(colors = listOf(Color(0xFFE3F2FD),Color(0xFFBBDEFB)))).padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally


        ){
            Text(
                text = "Final Score: $score / ${questions.size}",
                fontSize =24.sp
            )
            Spacer(modifier = Modifier.height(20.dp))

            if (score >= 8) {
                Text("Great Job! 👏")
            }else{
               Text("Try Harder 🙂")
            }

            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)

            ) {
                //REVIEW BUTTON
                Button(
                    onClick = {
                        showResults = false
                        reviewMode = true
                    }
                ) {
                    Text("Review Questions")
                }

                Button(
                    onClick = {
                        index = 0
                        score = 0
                        feedback = ""
                        answered = false
                        showResults = false
                        reviewMode = false
                    }
                ) {
                    Text("Retry")
                }
            }

        }
    } else {
        val current = questions[index]


        Column(
            modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(colors = listOf(Color(0xFFE3F2FD),Color(0xFFBBDEFB)))).padding(20.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${index + 1} of ${questions.size}",
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ){
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    //QUESTION

                    Text(text = current.text, fontSize = 20.sp)
                    Spacer(modifier = Modifier.height(20.dp))
                }

            }


            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
                //TRUE BUTTON
            ) {
                Button(
                    onClick = {
                        if (!answered) {
                            answered = true
                            if (current.answer) {
                                score++
                                feedback = "Correct!"
                            } else {
                                feedback = "Wrong!"
                            }
                        }
                    },
                    enabled = !answered
                ) {
                    Text("True")
                }

                //FALSE BUTTON
                Button(
                    onClick = {
                        if (!answered) {
                            answered = true
                            if (!current.answer) {
                                score++
                                feedback = "Correct!"
                            } else {
                                feedback = "Wrong!"
                            }
                        }
                    },
                    enabled = !answered
                ) {
                    Text("Myth")
                }
            }
            Spacer(modifier = Modifier.height(15.dp))

            //FEEDBACK

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = feedback)
                Spacer(modifier = Modifier.height(16.dp))
                //NEXT BUTTON
                Button(
                    onClick = {
                        if (answered) {
                            if (index < questions.size - 1) {
                                index++
                                feedback = ""
                                answered = false
                            } else {
                                showResults = true
                            }
                        }
                    },
                    enabled = answered
                ) {
                    Text("Next")
                }
            }
        }
    }
}