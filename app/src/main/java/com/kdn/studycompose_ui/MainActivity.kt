package com.kdn.studycompose_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
              setContent {
                ReUse {
                    Greeting(name = "ReUse")
                }
              }

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
        Surface(color = Color.LightGray){
            content()
        }
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

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
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