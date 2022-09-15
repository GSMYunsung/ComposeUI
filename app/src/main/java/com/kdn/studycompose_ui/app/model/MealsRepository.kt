package com.kdn.studycompose_ui.app.model

import android.util.Log
import com.kdn.studycompose_ui.app.model.api.MealsApi
import com.kdn.studycompose_ui.app.model.response.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MealsRepository @Inject constructor(

    private val mealsApi : MealsApi

) {

    // 코루틴 사용 O
    suspend fun getMeals( ) : MealsCategoriesResponse = mealsApi.getMeals()

    // 코루틴 사용 X
    /*fun getMeals(successCallback : (response : MealsCategoriesResponse?) -> Unit) = mealsApi.getMeals().enqueue(object : Callback<MealsCategoriesResponse>{

        override fun onResponse(
            call: Call<MealsCategoriesResponse>,
            response: Response<MealsCategoriesResponse>
        ) {
            if(response.isSuccessful){
                successCallback(response.body())}
        }

        override fun onFailure(call: Call<MealsCategoriesResponse>, t: Throwable) {
            Log.e("Error","Error!!!")
        }

    })*/

}