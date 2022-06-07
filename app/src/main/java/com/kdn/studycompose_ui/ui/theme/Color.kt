package com.kdn.studycompose_ui.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//Material Design 을 기본으로 하는 컬러들이 선언되어있다.

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val veryLightGrey = Color(0x60DCDCDC)
val lightGreen200 = Color(0x9932CD32)

// 기존과는 달리 composable 어노테이션이 최상위 옵션에 적용되지 않게 바뀌었다.

val Colors.Purple7 : Color
    @Composable
    get() = Purple700


val Colors.lightGreen : Color
    @Composable
    get() = lightGreen200