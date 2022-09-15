package com.kdn.studycompose_ui.study

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class DynamicContentExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(viewModel: MainViewModel = MainViewModel()){

    val newNameStateContent = viewModel.textFieldState.observeAsState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        GreetingMessage(
            newNameStateContent.value
        ) { newName -> viewModel.onTextChange(newText = newName) }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun GreetingMessage(
    textFieldValue : String,
    textFieldUpdate : (newName : String) -> Unit
    )
{

    TextField(value = textFieldValue, onValueChange = textFieldUpdate)

    // 다음 버튼으로 기존에 있는 배열에 마이클 String 추가
    Button(onClick = {}) {
        Text(text = textFieldValue)
    }
}

@Composable
fun Greeting2(name: String) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.h4)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
        MainScreen()
}