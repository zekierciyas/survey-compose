package com.zekierciyas.library.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zekierciyas.library.model.MultipleOptionUI
import com.zekierciyas.library.model.SurveyModel

@Composable
fun MultipleChoiceQuestion(
    question: SurveyModel,
    multipleOptionUI: MultipleOptionUI = MultipleOptionUI(),
    selectedAnswers: Set<String>,
    onAnswerSelected: (Set<String>) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray)
            .padding(16.dp)) {
            Text(
                text = question.questionTitle,
                fontFamily = multipleOptionUI.questionTitle.fontFamily,
                color = multipleOptionUI.questionTitle.color,
                fontSize = multipleOptionUI.questionTitle.fontSize,
                fontWeight = multipleOptionUI.questionTitle.fontWeight,
                letterSpacing = multipleOptionUI.questionTitle.letterSpacing,
                textAlign = multipleOptionUI.questionTitle.textAlign,
                lineHeight = multipleOptionUI.questionTitle.lineHeight,
                softWrap = multipleOptionUI.questionTitle.softWrap,
                maxLines = multipleOptionUI.questionTitle.maxLines,
                minLines = multipleOptionUI.questionTitle.minLines
            )
            Text(
                text = question.questionDescription,
                fontFamily = multipleOptionUI.questionDescription.fontFamily,
                color = multipleOptionUI.questionDescription.color,
                fontSize = multipleOptionUI.questionDescription.fontSize,
                fontWeight = multipleOptionUI.questionDescription.fontWeight,
                letterSpacing = multipleOptionUI.questionDescription.letterSpacing,
                textAlign = multipleOptionUI.questionDescription.textAlign,
                lineHeight = multipleOptionUI.questionDescription.lineHeight,
                softWrap = multipleOptionUI.questionDescription.softWrap,
                maxLines = multipleOptionUI.questionDescription.maxLines,
                minLines = multipleOptionUI.questionDescription.minLines
            )
        }

        Spacer(modifier = Modifier.padding(vertical = 4.dp))

        question.answers.forEach { answer ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        val newSelectedAnswers = if (answer in selectedAnswers) {
                            selectedAnswers - answer
                        } else {
                            selectedAnswers + answer
                        }
                        onAnswerSelected(newSelectedAnswers)
                    }
                    .background(
                        color = if (answer in selectedAnswers) multipleOptionUI.checkedColor
                        else multipleOptionUI.uncheckedColor
                    )
                    .border(
                        width = 1.dp,
                        color = multipleOptionUI.borderColor
                    )
                    .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    colors = CheckboxDefaults.colors(checkedColor = multipleOptionUI.uncheckedColor),
                    checked = answer in selectedAnswers,
                    onCheckedChange = null,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = answer,
                    fontFamily = multipleOptionUI.answer.fontFamily,
                    color = multipleOptionUI.answer.color,
                    fontSize = multipleOptionUI.answer.fontSize,
                    fontWeight = multipleOptionUI.answer.fontWeight,
                    letterSpacing = multipleOptionUI.answer.letterSpacing,
                    textAlign = multipleOptionUI.answer.textAlign,
                    lineHeight = multipleOptionUI.answer.lineHeight,
                    softWrap = multipleOptionUI.answer.softWrap,
                    maxLines = multipleOptionUI.answer.maxLines,
                    minLines = multipleOptionUI.answer.minLines
                )
            }

            Spacer(modifier = Modifier.padding(vertical = 2.dp))
        }
    }
}