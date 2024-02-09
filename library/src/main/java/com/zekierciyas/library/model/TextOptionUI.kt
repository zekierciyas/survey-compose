package com.zekierciyas.library.model

import androidx.compose.ui.graphics.Color
data class TextOptionUI (
    val questionTitle: SurveyText = SurveyText(),
    val questionDescription: SurveyText = SurveyText(),
    val answer: SurveyText = SurveyText(),
    val borderColor: Color = Color.Gray,
    val backgroundColor: Color = Color.White,
    val hintText: SurveyText = SurveyText(),
    val surveyOutlinedText: SurveyOutlinedText = SurveyOutlinedText()
)