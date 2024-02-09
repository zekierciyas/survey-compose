package com.zekierciyas.library.model

import androidx.compose.ui.graphics.Color

data class SurveyOutlinedText(
    val focusedTextColor: Color = Color.Gray,
    val unfocusedTextColor: Color = Color.Gray,
    val disabledTextColor: Color = Color.Gray,
    val focusedContainerColor: Color = Color.White,
    val unfocusedContainerColor: Color = Color.White,
    val focusedBorderColor: Color = Color.Gray,
    val focuedLabelColor: Color = Color.Gray
)
