package com.kdn.studycompose_ui

data class UserProfile constructor(val name : String, val status : Boolean , val drawableId : Int)

val userProfileList = arrayListOf<UserProfile>(
    UserProfile(name ="John Doe" , status = true, drawableId = R.drawable.men),
    UserProfile(name ="Anna Joans" , status = false, drawableId = R.drawable.women) ,
    UserProfile(name ="Coco Pams" , status = false, drawableId = R.drawable.men) ,
    UserProfile(name ="Hello Pams" , status = true, drawableId = R.drawable.men) ,
    UserProfile(name ="Kim suki" , status = false, drawableId = R.drawable.women) ,
    UserProfile(name ="hi by man" , status = true, drawableId = R.drawable.men) ,
    UserProfile(name ="nickname" , status = true, drawableId = R.drawable.women) ,
    UserProfile(name ="none" , status = false, drawableId = R.drawable.women) ,

)