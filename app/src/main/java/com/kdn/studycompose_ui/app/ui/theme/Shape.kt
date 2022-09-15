package com.kdn.studycompose_ui.app.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

// 도형의 모양을 선언하는 클래스이다.

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = CutCornerShape(topEnd = 24.dp),
    large = RoundedCornerShape(0.dp)
)