package com.kdn.studycompose_ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Ui {

    @Composable
    fun GreetingWidthMaxText(name: String) {
        Text(text = "Hello $name!", modifier = Modifier.fillMaxWidth())
    }

    @Composable
    fun GreetingHeightMaxText(name: String) {
        Text(text = "Hello $name!", modifier = Modifier.fillMaxHeight())
    }

    @Composable
    fun GreetingSizeText(name: String) {
        Text(text = "Hello $name!", modifier = Modifier.size(width = 100.dp, height = 100.dp ))
    }

    @Composable
    fun GreetingClickText(name: String) {
        Text(text = "Hello $name!", modifier = Modifier.clickable {  })
    }

    @Composable
    fun GreetingPaddingText(name: String) {
        Text(text = "Hello $name!", modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp))
    }
}