package com.zekierciyas.library.model

import androidx.compose.ui.graphics.Color
data class SingleOptionUI (
    val questionTitle: SurveyText = SurveyText(),
    val questionDescription: SurveyText = SurveyText(),
    val answer: SurveyText = SurveyText(),
    val selectedColor: Color = Color.White,
    val unSelectedColor: Color = Color.Gray,
    val borderColor: Color = Color.Gray,
    val backgroundColor: Color = Color.Gray
)