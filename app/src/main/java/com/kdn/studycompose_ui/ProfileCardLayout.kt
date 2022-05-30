package com.kdn.studycompose_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.cardview.widget.CardView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kdn.studycompose_ui.ui.theme.StudyCompose_UITheme

class ProfileCardLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProfileMainScreen()
        }
    }
}



@Composable
fun ProfileMainScreen() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.LightGray,
            ) {

            ProfileCard()

          }
}

@Composable
fun ProfileContent() {
    Text(text = "John Doe")
}

@Composable
fun ProfilePicture() {

    Card(
        shape = CircleShape,
        border = BorderStroke(width = 2.dp,color = Color.Green),
        modifier = Modifier.padding(16.dp)
        )
    {
        Image(
            painter = painterResource(id = R.drawable.men),
            contentDescription = "Content description",
            modifier = Modifier.size(72.dp)
        )
    }

}

@Composable
fun ProfileCard(){
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp
        ) {

        Row(
            modifier = Modifier.wrapContentSize()
        )
        {
            ProfilePicture()
            ProfileContent()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    ProfileMainScreen()
}