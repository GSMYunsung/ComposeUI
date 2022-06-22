package com.kdn.studycompose_ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.cardview.widget.CardView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kdn.studycompose_ui.ui.theme.Shapes
import com.kdn.studycompose_ui.ui.theme.StudyCompose_UITheme
import com.kdn.studycompose_ui.ui.theme.lightGreen

class ProfileCardLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudyCompose_UITheme() {
                ProfileMainScreen()
            }
        }
    }
}

@Composable
fun ProfileMainScreen(userProfiles : List<UserProfile> = userProfileList) {

        // 기본 머티리얼 디자인 레이아웃 구조로 UI를 구현 할 수 있다.

        Scaffold(topBar = { AppBar() }) {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                
                LazyColumn{

                    items(userProfiles){ userProfile ->

                        ProfileCard(userProfile = userProfile)
                    }

                }
            }
        }

}

@Composable
fun AppBar(){
    TopAppBar(
        navigationIcon = {
            Icon(
            Icons.Default.Home,
            "content description",
             modifier = Modifier.padding(horizontal = 12.dp)

            )},

        title = { Text(text = "Messaging Application users")}
    )
}

@Composable
fun ProfileContent(userName : String, onlineStatus : Boolean) {

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()

    ) {

        CompositionLocalProvider(
            values = arrayOf(LocalContentAlpha provides
                    if (onlineStatus) 1f else ContentAlpha.medium)) {
            Text(text = userName, style = MaterialTheme.typography.h5)
        }

        CompositionLocalProvider(values = arrayOf(LocalContentAlpha provides ContentAlpha.medium)) {
            Text(text = if (onlineStatus) "Active now " else "Offline",style = MaterialTheme.typography.body2)
        }
        

    }
}

@Composable
fun ProfilePicture(pictureUri : String,onlineStatus : Boolean) {

    Card(
        shape = CircleShape,
        border = BorderStroke(
                width = 2.dp ,
                color = if(onlineStatus) MaterialTheme.colors.lightGreen
                        else Color.Red),

        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
        )
    {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(pictureUri)
                .crossfade(true)
                .build(),

            placeholder = painterResource(id = R.drawable.men),
            contentDescription = "Content description",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )

//        Image(
//            contentDescription = "Content description",
//            modifier = Modifier.size(72.dp),
//            contentScale = ContentScale.Crop
//        )
    }

}

@Composable
fun ProfileCard(userProfile: UserProfile){
    Card(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .wrapContentHeight(align = Alignment.Top),
        elevation = 8.dp,
        backgroundColor = Color.White
        ) {

        Row(
            modifier =
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        )
        {
            ProfilePicture(userProfile.pictureUrl, userProfile.status)
            ProfileContent(userProfile.name,userProfile.status)
        }

    }
}


@Composable
fun UserProfileDetailsScreen(userProfile : UserProfile = userProfileList[0]) {

    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            ProfileCard(userProfile = userProfile)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
        StudyCompose_UITheme() {
            ProfileMainScreen()
        }
}