package com.zekierciyas.library.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.zekierciyas.library.model.SurveyModel
import com.zekierciyas.library.model.TextOptionUI

@Composable
fun TextQuestion(
    question: SurveyModel,
    enteredText: String,
    textOptionUI: TextOptionUI = TextOptionUI(),
    onTextChanged: (String) -> Unit
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
                fontFamily = textOptionUI.questionTitle.fontFamily,
                color = textOptionUI.questionTitle.color,
                fontSize = textOptionUI.questionTitle.fontSize,
                fontWeight = textOptionUI.questionTitle.fontWeight,
                letterSpacing = textOptionUI.questionTitle.letterSpacing,
                textAlign = textOptionUI.questionTitle.textAlign,
                lineHeight = textOptionUI.questionTitle.lineHeight,
                softWrap = textOptionUI.questionTitle.softWrap,
                maxLines = textOptionUI.questionTitle.maxLines,
                minLines = textOptionUI.questionTitle.minLines
            )
            Text(
                text = question.questionDescription,
                fontFamily = textOptionUI.questionDescription.fontFamily,
                color = textOptionUI.questionDescription.color,
                fontSize = textOptionUI.questionDescription.fontSize,
                fontWeight = textOptionUI.questionDescription.fontWeight,
                letterSpacing = textOptionUI.questionDescription.letterSpacing,
                textAlign = textOptionUI.questionDescription.textAlign,
                lineHeight = textOptionUI.questionDescription.lineHeight,
                softWrap = textOptionUI.questionDescription.softWrap,
                maxLines = textOptionUI.questionDescription.maxLines,
                minLines = textOptionUI.questionDescription.minLines
            )
        }

        OutlinedTextField(
            value = enteredText,
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = textOptionUI.surveyOutlinedText.focusedTextColor,
                focusedBorderColor = textOptionUI.surveyOutlinedText.focusedBorderColor,
                disabledTextColor = textOptionUI.surveyOutlinedText.disabledTextColor,
                focusedContainerColor = textOptionUI.surveyOutlinedText.focusedContainerColor,
                unfocusedContainerColor  = textOptionUI.surveyOutlinedText.unfocusedContainerColor,
                focusedLabelColor = textOptionUI.surveyOutlinedText.focuedLabelColor,
                cursorColor = textOptionUI.surveyOutlinedText.focusedTextColor

            ),
            onValueChange = { onTextChanged(it) },
            label = { Text(
                text = textOptionUI.hintText.text,
                fontFamily = textOptionUI.questionDescription.fontFamily,
                color = textOptionUI.questionDescription.color,
                fontSize = textOptionUI.questionDescription.fontSize,
                fontWeight = textOptionUI.questionDescription.fontWeight,
                letterSpacing = textOptionUI.questionDescription.letterSpacing,
                textAlign = textOptionUI.questionDescription.textAlign,
                lineHeight = textOptionUI.questionDescription.lineHeight,
                softWrap = textOptionUI.questionDescription.softWrap,
                maxLines = textOptionUI.questionDescription.maxLines,
                minLines = textOptionUI.questionDescription.minLines
            ) },
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            )
        )
    }
}