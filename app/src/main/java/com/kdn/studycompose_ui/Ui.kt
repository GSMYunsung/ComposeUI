package com.kdn.studycompose_ui

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Ui {

    // compose 는 순서에 따른 클릭 범위를 설정해줄 수 있다.

    // padding 을 먼저 or clickable 을 먼저
    // 크기를 먼저 지정할지, padding 을 먼저 지정해줄지.

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

    @Composable
    fun GreetingTextStyle(name: String){
        Text(text = "Hello $name!", style = TextStyle(color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 18.sp))
    }

    @Composable
    fun GreetingTextStyleTheme(name: String){
        Text(text = "Hello $name!", style = TextStyle(color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 18.sp))
    }

    @Composable
    fun GreetingScreenStylePhoneSize(name: String){
        Surface(color = Color.DarkGray, modifier = Modifier.fillMaxSize()){}
    }

    // Modifier.wrapContentSize() 를 사용하면 자신의 text 크기만큼만 공간을 차지한다.

    // Text 는 Modifier.fillMaxSize() 로 설정해줄필요가 없다.
    // 그이유는 Text 가 이미 text 자신만을 영역으로 지정하기때문이다.

    @Composable
    fun GreetingScreenInText(){
        Surface(
            color = Color.DarkGray,
            modifier = Modifier.fillMaxSize()) {

            Surface(
                color = Color.Green,
                modifier = Modifier.wrapContentSize(align = Alignment.Center)) {
                Text(
                    text = "Wrapped content",
                    style = MaterialTheme.typography.h3)
            }

        }
    }

    @Composable
    fun GreetingScreenSetRow(){
        Surface(
            color = Color.Gray,
            modifier = Modifier.fillMaxSize()
        ) {

            Row() {
                Surface(
                    color = Color.Red,
                    modifier = Modifier
                        .height(600.dp)
                        .width(60.dp)
                ) { }

                Surface(
                    color = Color.Blue,
                    modifier = Modifier
                        .height(600.dp)
                        .width(60.dp)
                ) { }

            }

        }
    }

    @Composable
    fun GreetingScreenSetSpace(){
        Surface(
            color = Color.Gray,
            modifier = Modifier.fillMaxSize()
        ) {

            Row(
                modifier = Modifier.fillMaxSize(),

                // SpaceBetween = 각 아이템과의 거리만 남기고 양옆 layout의 여백을 아에 없애고 정렬
                // SpaceAround = 각 아이템과의 여백과 양옆 layout 의 여백을 생각하여 정렬
                // SpaceEvenly = 각 아이템과 양옆 layout 의 여백이 모두 동일하다.

                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically) {

                ColoredSquare(Color.Red)
                ColoredSquare(Color.Green)
                ColoredSquare(Color.DarkGray)
                ColoredSquare(Color.LightGray)

            }

        }
    }

    @Composable
    fun ColoredSquare(color : Color){
        Surface(
            color = color,
            modifier = Modifier
                .height(600.dp)
                .width(60.dp)
        ) { }
    }

    @Composable
    fun GreetingScreenSetColumnInRow(){

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
    fun DynamicContentExample(){

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


}