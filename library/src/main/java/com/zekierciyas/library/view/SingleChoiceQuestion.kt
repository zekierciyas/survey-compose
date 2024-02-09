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
import com.zekierciyas.library.model.SingleOptionUI
import com.zekierciyas.library.model.SurveyModel

@Composable
fun SingleChoiceQuestion(
    question: SurveyModel,
    selectedAnswer: String?,
    singleOptionUI: SingleOptionUI = SingleOptionUI(),
    onAnswerSelected: (String) -> Unit
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
                fontFamily = singleOptionUI.questionTitle.fontFamily,
                color = singleOptionUI.questionTitle.color,
                fontSize = singleOptionUI.questionTitle.fontSize,
                fontWeight = singleOptionUI.questionTitle.fontWeight,
                letterSpacing = singleOptionUI.questionTitle.letterSpacing,
                textAlign = singleOptionUI.questionTitle.textAlign,
                lineHeight = singleOptionUI.questionTitle.lineHeight,
                softWrap = singleOptionUI.questionTitle.softWrap,
                maxLines = singleOptionUI.questionTitle.maxLines,
                minLines = singleOptionUI.questionTitle.minLines
            )
            Text(
                text = question.questionDescription,
                fontFamily = singleOptionUI.questionDescription.fontFamily,
                color = singleOptionUI.questionDescription.color,
                fontSize = singleOptionUI.questionDescription.fontSize,
                fontWeight = singleOptionUI.questionDescription.fontWeight,
                letterSpacing = singleOptionUI.questionDescription.letterSpacing,
                textAlign = singleOptionUI.questionDescription.textAlign,
                lineHeight = singleOptionUI.questionDescription.lineHeight,
                softWrap = singleOptionUI.questionDescription.softWrap,
                maxLines = singleOptionUI.questionDescription.maxLines,
                minLines = singleOptionUI.questionDescription.minLines
            )
        }

        Spacer(modifier = Modifier.padding(vertical = 4.dp))

        question.answers.forEach { answer ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onAnswerSelected(answer)
                    }
                    .background(
                        color = if (answer == selectedAnswer) Color.Gray else Color.White
                    )
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    colors = RadioButtonDefaults.colors(
                        selectedColor = singleOptionUI.selectedColor,
                        unselectedColor = singleOptionUI.unSelectedColor),
                    selected = answer == selectedAnswer,
                    onClick = null,
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = answer,
                    fontFamily = singleOptionUI.answer.fontFamily,
                    color = singleOptionUI.answer.color,
                    fontSize = singleOptionUI.answer.fontSize,
                    fontWeight = singleOptionUI.answer.fontWeight,
                    letterSpacing = singleOptionUI.answer.letterSpacing,
                    textAlign = singleOptionUI.answer.textAlign,
                    lineHeight = singleOptionUI.answer.lineHeight,
                    softWrap = singleOptionUI.answer.softWrap,
                    maxLines = singleOptionUI.answer.maxLines,
                    minLines = singleOptionUI.answer.minLines
                )
            }

            Spacer(modifier = Modifier.padding(vertical = 2.dp))
        }
    }
}
