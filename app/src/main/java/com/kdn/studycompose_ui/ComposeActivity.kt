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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kdn.studycompose_ui.ui.theme.StudyCompose_UITheme

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { GreetingText("world") }

    }

    // 순서에 따른 클릭 범위를 설정해줄 수 있다.

    // padding 을 먼저 or clickable 을 먼저
    // 크기를 먼저 지정할지, padding 을 먼저 지정해줄지.

    @Composable
    fun GreetingText(name: String) {
        Text(text = "Hello $name!",
            modifier = Modifier
                .height(240.dp)
                .width(200.dp)
                .padding(24.dp)
                .clickable {  })
    }

//    @Composable
//    fun GreetingButton(name : String){
//        Button(onClick = {}) {
//            Greeting(name = "$name Button")
//        }
//    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview2() {
        StudyCompose_UITheme {
           GreetingText(name = "world")
        }
    }
}