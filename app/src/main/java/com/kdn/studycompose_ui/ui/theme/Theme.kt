package com.kdn.studycompose_ui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

// 테마를 구성하는 클래스이다.

// Color 에서 정의 되어있는 컬러를 바탕으로 다크, 기본테마를 정의할 수 있고,
// 기본테마를 정의하여 Type 에서와 같이 default 값을 적용 시킬 수 도 있다,


private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun StudyCompose_UITheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {

    // 테마적용 부분

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    // 실질적 UI 적용 부분

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}