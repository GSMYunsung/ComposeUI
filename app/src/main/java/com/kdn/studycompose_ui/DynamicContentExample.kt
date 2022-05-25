package com.kdn.studycompose_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kdn.studycompose_ui.ui.theme.StudyCompose_UITheme

private val namesList : ArrayList<String> = arrayListOf(
    "john","Michael","Andrew","Danna","JOJI")

class DynamicContentExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingList(names = namesList)
        }
    }
}

@Composable
fun GreetingList(names : ArrayList<String>){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        for(name in names){
            Greeting2(name = name)
        }
        
        Button(onClick = {names.add("new name")}) {
            Text(text = "Add new name")
        }
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
        GreetingList(names = namesList)
}