package com.kdn.studycompose_ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kdn.studycompose_ui.ui.theme.StudyCompose_UITheme

// Compose 에서는 재사용성을 강조!
// 재사용이 가능하게 쪼개서 관리하여야 UI를 수정하고 사용하는데에 더 유리함!

//함수를 여러번 사용할 때 마다 배경색을 계속 지정해주는것은 구조상 이상함

//그래서 다음 3번과 같은 구조를 사용

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//     -------------------------- 1. 기본 버전 ---------------------------------------
//        setContent {
//            StudyCompose_UITheme {
//                // Surface를 사용하여 텍스트의 배경색을 지정하고 , Android 텍스트를 넘겨주어 UI를 생성함.
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                }
//            }
//        }
//     --------------------------- 2. 따로 UI Theme 를 함수로 빼준 버전 ---------------------
//            setContent {
//                NotReUse()
//            }
//     ---------------------------- 3. 재사용성을 고려한 공통의 컨테이너 지정 버전 ----------------
//              setContent {
//                ReUse {
//                    Greeting(name = "ReUse")
//                }
//              }
//      ---------------------------- 4. Column & Divider -------------------------------

//        setContent {
//                ReUse {
//                    MyScreenContent()
//                }
//              }

//      ---------------------------- 5. State -------------------------------

        // 상태변경에 대응하는것
        // Composable 함수를 호출하여 데이터를 Ui로 변환한다.
        // 데이터가 변경되면 새 데이터로 이러한 기능을 이용하여 업데이트된 UI를 구성한다.

        //  Compose 는 기존의 옵저버 패턴과 같은 composing 기능을 제공한다.
        // 또한 Compose 는 데이터가 변경된 구성요소만 재구성한다.

        // remember : 데이터가 변경될 때의 상태를 유지한다.
        // mutableStateOf 는 가변메모리를 사용할 수 있게 해준다.

        // 화면의 다른위치에 컴포저블의 여러 객체들이 자체 버전을 가지고 있는것이다!

//                setContent {
//                ReUse {
//                    Counter()
//                }
//              }

//      ---------------------------- 6. Source of truth -------------------------------

        // Composable 함수에서 State 는 함수를 사용하거나 제어하기위한 유일한 방법이기때문에 외부에 노출되어야한다.
        // -> State Hoisting
        // 즉, 내부상태를 호출한 함수에 의해 제어 가능하게 만드는 방법이라는 것이다.

        // 이런식으로 구조를 바꾸면 Counter 에서 관리되던 Count 값을 여기서 관리하고
        // 람다식을 활용하여 호출한 함수의 값을 변경해준다.

        // 이렇게되면 Counter 함수는 오직 버튼 클릭시 숫자를 증가시키고 텍스트를 출력시키는 역할만을 하게된다.

        setContent {
            ReUse {

                val counterState = remember { mutableStateOf(0)}

                SourceOfTruthCounter(
                    count = counterState.value,
                    updateCount = {newCount ->
                        counterState.value = newCount
                    }
                )
            }
        }
    }
}

//Column & Divider 로 칸을 recycler_view 처럼 나눌 수 있다.
// 또한 Kotlin 기반이기때문에 반복문, 컬렉션등을 사용하여 UI를 구성 할 수 도있다.
@Composable
fun MyScreenContent() {
    Column {
        Greeting(name = "CEO 최윤성")
        Divider(color = Color.Black)
        Greeting("반갑습니다.")
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
            Greeting(name = name)
            Divider(color = Color.Black)
        }
    }
}

// LazyColumn : 기존의 RecyclerView 와 동일한 기능을 하지만 뷰를 재활용하진 않는다.

@Composable
fun MyScreenContent(names: List<String> = List(100) { "안드로이드 #$it" }) {
    val counterState = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()) {
        NameList(names, Modifier.weight(1f))
        SourceOfTruthCounter(
            count = counterState.value,
            updateCount = { newCount ->
                counterState.value = newCount
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun columnPreview(){
    ReUse {
        MyScreenContent()
    }
}

@Composable
fun NotReUse(){
    StudyCompose_UITheme {
        Surface(color = Color.Yellow){
            Greeting(name = "NotReUseText!")
        }
    }
}

// 다음과 같이 람다식으로 @Composable 을 지정해주도록 한다.
@Composable
fun ReUse(content : @Composable () -> Unit){
    StudyCompose_UITheme {
        Surface(color = Color.Green){
            content()
        }
    }
}

@Composable
fun SourceOfTruthCounter(count : Int, updateCount : (Int) -> Unit){
    Button(onClick = {updateCount(count+1)},
        // 버튼 배경색 바꾸기
    colors = ButtonDefaults.buttonColors(backgroundColor = if(count / 2 == 0 ) Color.Cyan else Color.White)) {
     Text(text = "$count 번 클릭하셨네요!")
    }
}

@Composable
fun Counter(){

    val count = remember { mutableStateOf(0)}

    Button(onClick = {count.value++}){
        Text("${count.value} 번 클릭했습니다.")
    }

}

@Preview(showBackground = true)
@Composable
fun ReUsePreview() {
    ReUse {
        Greeting("ReUseText!")
    }
}

@Preview(showBackground = true)
@Composable
fun NotReUsePreview() {
    NotReUse()
}

// 텍스트를 받아서 생성해주는 역할
// modifier 를 사용하면 Surface 와 Text 와 같은 대부분의 UI 컴포넌트를 지정 가능하다.

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",modifier = Modifier.padding(10.dp))
}

//Preview : 레이아웃 미리보기 지원
@Preview(showBackground = true)
//Composable : 기존의 View 역할. 실행시 컴파일러에게 UI를 그리게 하며,
// 반환 타입을 정하지 않고 순서를 신경쓰지 않으며 동시실행 가능하고 갱신, 취소될 수 있다.
@Composable
fun DefaultPreview() {
    StudyCompose_UITheme {
        Surface(color = Color.White) {
            Greeting("Android")
        }
    }
}