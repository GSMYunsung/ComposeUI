package com.kdn.studycompose_ui.study

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kdn.studycompose_ui.app.ui.theme.StudyCompose_UITheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }

    }

    @Composable
    fun MainScreen(){
        Surface(
            color = Color.Gray,
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ColoredSquare(Color.Red)
                    ColoredSquare(Color.Green)
                    
                }
                ColoredSquare(Color.DarkGray)
                ColoredSquare(Color.LightGray)
                ColoredSquare(Color.Cyan)
                
            }
            
        }
    }

    @Composable
    fun  ColoredSquare(color : Color){
        Surface(
            color = color,
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
        ) { }
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