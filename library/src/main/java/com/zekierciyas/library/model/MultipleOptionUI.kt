package com.zekierciyas.library.model

import androidx.compose.ui.graphics.Color
data class MultipleOptionUI (
    val questionTitle: SurveyText = SurveyText(),
    val questionDescription: SurveyText = SurveyText(),
    val answer: SurveyText = SurveyText(),
    val checkedColor: Color = Color.Gray,
    val uncheckedColor: Color = Color.White,
    val borderColor: Color = Color.Gray,
    val backgroundColor: Color = Color.Gray
)