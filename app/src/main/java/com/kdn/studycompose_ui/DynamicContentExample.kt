package com.kdn.studycompose_ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
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
fun MainScreen(){

    // 이름 담기
    val greetingListState = remember{mutableStateListOf<String>("John","Amanda")}


    val newNameStateContent = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        GreetingList(
            greetingListState,
            { greetingListState.add(newNameStateContent.value) },
            newNameStateContent.value,
            {newName -> newNameStateContent.value = newName }
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun GreetingList(
    namesList : List<String>,
    buttonClick : () -> Unit,
    textFieldValue : String,
    textFieldUpdate : (newName : String) -> Unit
    )
{

    // 이름을 이용한 UI 구성
    for(name in namesList) {
        Greeting2(name = name)
    }

    // TextFieldValue : Text 가 쳐질때마다 실시간 업데이트를 해준다.
    // textFieldUpdate : Text 가 변경될때마다 변경신호를 준다. 다만, 람다를 사용하면 value 값을 return 할 수 있다.

    TextField(value = textFieldValue, onValueChange = textFieldUpdate)

    // 다음 버튼으로 기존에 있는 배열에 마이클 String 추가
    Button(onClick = buttonClick) {
        Text(text = "Add new name")
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