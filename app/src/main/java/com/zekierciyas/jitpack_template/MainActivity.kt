package com.zekierciyas.jitpack_template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.zekierciyas.library.model.QuestionType
import com.zekierciyas.library.model.SurveyModel
import com.zekierciyas.library.view.SurveyScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurveyPreview()
        }
    }
}

@Composable
fun SurveyView() {

    var showMessage by remember { mutableStateOf(false) }

    val sampleSurvey = listOf(
        SurveyModel(
            questionType = QuestionType.MULTIPLE_CHOICE,
            questionId = "id1",
            questionTitle = "1) Select your favorite color:",
            answers = listOf("Red", "Green", "Blue"),
            questionDescription = "Description"
        ),
        SurveyModel(
            questionType = QuestionType.SINGLE_CHOICE,
            questionId ="id2",
            questionTitle ="2) Choose your preferred programming language:",
            answers = listOf("Java", "Kotlin", "Swift", "Python"),
            questionDescription = "Description"
        ),
        SurveyModel(
            questionType = QuestionType.TEXT,
            questionId ="id3",
            questionTitle ="3) Choose your preferred programming language:",
            questionDescription = "Description"
        )
    )
    SurveyScreen(
        survey = sampleSurvey,
        callbackAnswers =  {

        },
        callbackAllAnswered = {
            showMessage = true
        })

    if (showMessage) {
        Snackbar(
            action = {
                Button(
                    onClick = { showMessage = false }
                ) {
                    Text("Dismiss")
                }
            }
        ) {
            Text(text = "All questions are done")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SurveyPreview() {
    SurveyView()
}