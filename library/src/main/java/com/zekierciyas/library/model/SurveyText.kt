package com.zekierciyas.library.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

data class SurveyText(
   val color: Color = Color.Unspecified,
   val fontSize: TextUnit = TextUnit.Unspecified,
   val fontStyle: FontStyle? = null,
   val fontWeight: FontWeight? = null,
   val fontFamily: FontFamily? = null,
   val letterSpacing: TextUnit = TextUnit.Unspecified,
   val textDecoration: TextDecoration? = null,
   val textAlign: TextAlign? = null,
   val lineHeight: TextUnit = TextUnit.Unspecified,
   val overflow: TextOverflow = TextOverflow.Clip,
   val softWrap: Boolean = true,
   val maxLines: Int = Int.MAX_VALUE,
   val minLines: Int = 1,
   val text: String = "Enter your answer here"
)