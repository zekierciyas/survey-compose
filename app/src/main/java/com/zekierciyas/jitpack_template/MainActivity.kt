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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.zekierciyas.library.model.MultipleOptionUI
import com.zekierciyas.library.model.QuestionType
import com.zekierciyas.library.model.SingleOptionUI
import com.zekierciyas.library.model.SurveyModel
import com.zekierciyas.library.model.SurveyOutlinedText
import com.zekierciyas.library.model.SurveyText
import com.zekierciyas.library.model.TextOptionUI
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
        backgroundColor = Color.White,
        singleOptionUI = SingleOptionUI(
            questionTitle = SurveyText(
                color = Color.DarkGray,
                fontWeight = FontWeight.ExtraBold
            ),
            answer = SurveyText(
                color = Color.DarkGray,
                fontWeight = FontWeight.Medium
            ),
            selectedColor = Color.White,
            unSelectedColor = Color.Gray,
            borderColor = Color.Gray
        ),
        multipleOptionUI = MultipleOptionUI(
            questionTitle = SurveyText(
                color = Color.DarkGray,
                fontWeight = FontWeight.ExtraBold
            ),
            answer = SurveyText(
                color = Color.DarkGray,
                fontWeight = FontWeight.Medium
            ),
            checkedColor = Color.Gray,
            uncheckedColor = Color.White,
            borderColor = Color.Gray
        ),
        textOptionUI = TextOptionUI(
            questionTitle = SurveyText(
                color = Color.DarkGray,
                fontWeight = FontWeight.ExtraBold
            ),
            answer = SurveyText(
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            ),
            borderColor = Color.Gray,
            backgroundColor = Color.White,
            surveyOutlinedText = SurveyOutlinedText(
                focusedTextColor = Color.DarkGray,
                unfocusedContainerColor = Color.White,
                focuedLabelColor = Color.DarkGray
            )
        ),
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