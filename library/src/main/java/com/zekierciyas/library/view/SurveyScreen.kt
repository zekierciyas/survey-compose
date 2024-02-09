package com.zekierciyas.library.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zekierciyas.library.model.MultipleOptionUI
import com.zekierciyas.library.model.QuestionType
import com.zekierciyas.library.model.SingleOptionUI
import com.zekierciyas.library.model.SurveyModel
import com.zekierciyas.library.model.TextOptionUI

@Composable
fun SurveyScreen(
    survey: List<SurveyModel>,
    backgroundColor: Color = Color.White,
    singleOptionUI: SingleOptionUI = SingleOptionUI(),
    multipleOptionUI: MultipleOptionUI = MultipleOptionUI(),
    textOptionUI: TextOptionUI = TextOptionUI(),
    callbackAnswers: (Map<String, Set<String>>) -> Unit = {},
    callbackAllAnswered: (Map<String, Set<String>>) -> Unit = {}
) {
    var answers by remember { mutableStateOf<Map<String, Set<String>>>(emptyMap()) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        items(survey.size) { index ->
            val question = survey[index]
            when (question.questionType) {
                QuestionType.MULTIPLE_CHOICE -> {
                    MultipleChoiceQuestion(
                        question = question,
                        selectedAnswers = answers[question.questionId] ?: emptySet(),
                        multipleOptionUI = multipleOptionUI,
                        onAnswerSelected = { selectedAnswer ->
                            answers = answers + (question.questionId to selectedAnswer)
                            callbackAnswers.invoke(answers)
                            if (selectedAnswer.isEmpty()) {
                                answers - question.questionDescription
                                return@MultipleChoiceQuestion
                            }
                            if (answers.size == survey.size) callbackAllAnswered.invoke(answers)
                        }
                    )
                    Spacer(modifier = Modifier.padding(
                        vertical = 4.dp
                    ))
                }
                QuestionType.SINGLE_CHOICE -> {
                    SingleChoiceQuestion(
                        question = question,
                        singleOptionUI = singleOptionUI,
                        selectedAnswer = answers[question.questionId]?.firstOrNull(),
                        onAnswerSelected = { selectedAnswer ->
                            answers = answers + (question.questionId to setOf(selectedAnswer))
                            callbackAnswers.invoke(answers)
                            if (answers.size == survey.size) callbackAllAnswered.invoke(answers)
                        }
                    )
                    Spacer(modifier = Modifier.padding(
                        vertical = 4.dp
                    ))
                }
                QuestionType.TEXT -> {
                    TextQuestion(
                        question = question,
                        textOptionUI = textOptionUI,
                        enteredText = answers[question.questionId]?.firstOrNull() ?: "",
                        onTextChanged = { newText ->
                            answers = answers + (question.questionId to setOf(newText))
                            callbackAnswers.invoke(answers)
                            if (answers.size == survey.size) callbackAllAnswered.invoke(answers)
                        }
                    )
                    Spacer(modifier = Modifier.padding(
                        vertical = 4.dp
                    ))
                }
            }
        }
    }
}