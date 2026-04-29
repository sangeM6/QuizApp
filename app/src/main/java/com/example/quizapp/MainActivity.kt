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
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        setContent {
            QuizAppTheme {
                    QuizApp()
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
fun QuizApp() {
    var index by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var feedback by remember { mutableStateOf("") }
    var answered by remember { mutableStateOf(false) }
    var showResults by remember { mutableStateOf(false) }

    if (showResults) {

        //RESULT SCREEN
        Column(
            Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Center

        ){
            Text(
                text = "Final Score: $score / ${questions.size}",
                fontSize =24.sp
            )
        }
    } else {
        val current = questions[index]

        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Center
        ){
            //QUESTION
            Text(text = current.text, fontSize =20.sp)

            Spacer(modifier = Modifier.height(20.dp))

            //TRUE BUTTON
            Button(
                onClick = {
                    if (!answered){
                        answered = true
                        if (current.answer){
                            score++
                            feedback = "Correct!"
                        }else{
                            feedback = "Wrong!"
                        }
                    }
                },
                enabled = !answered
            ){
                Text("True")
            }
            Spacer(modifier =Modifier.height(10.dp))

            //FALSE BUTTON
            Button(
                onClick = {
                    if(!answered) {
                        answered =true
                        if (!current.answer) {
                            score++
                            feedback = "Correct!"
                        } else {
                            feedback = "Wrong!"
                        }
                    }
                },
                enabled = !answered
            ){
                Text("Myth")
            }
            Spacer(modifier = Modifier.height(20.dp))
            //FEEDBACK
            Text(text = feedback)
            Spacer(modifier = Modifier.height(20.dp))
            //NEXT BUTTON

            Button(
                onClick = {
                    if(answered) {
                        if(index < questions.size -1){
                            index++
                            feedback =""
                            answered = false
                        } else {
                            showResults = true
                        }
                    }
                },
                enabled = answered
            ){
                Text("Next")
            }
        }
    }
}