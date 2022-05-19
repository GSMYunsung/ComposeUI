package com.kdn.studycompose_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kdn.studycompose_ui.ui.theme.StudyCompose_UITheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { MainScreen() }

    }

    @Composable
    fun MainScreen(){
        Surface(
            color = Color.Gray,
            modifier = Modifier.fillMaxSize()) {

            Surface(
                color = Color.Green,
                modifier = Modifier.wrapContentSize()) {
                Text(
                    text = "Wrapped content",
                    style = MaterialTheme.typography.h3)
            }
            
        }
    }

    @Composable
    fun GreetingText(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview2() {
        StudyCompose_UITheme {
            MainScreen()
        }
    }
}