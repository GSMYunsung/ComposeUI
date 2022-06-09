package com.kdn.studycompose_ui

data class UserProfile constructor(val name : String, val status : Boolean , val drawableId : Int)

val userProfileList = arrayListOf<UserProfile>(
    UserProfile(name ="John Doe" , status = true, drawableId = R.drawable.men),
    UserProfile(name ="Anna Joans" , status = false, drawableId = R.drawable.women)
)