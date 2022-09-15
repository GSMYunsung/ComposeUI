package com.kdn.studycompose_ui.app.model.api

import retrofit2.Call
import com.kdn.studycompose_ui.app.model.response.MealsCategoriesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MealsApi {

    // 코루틴 사용 x

//    @GET("categories.php")
//    fun getMeals(
//            // no query
//        ) : Call<MealsCategoriesResponse>

    // 코루틴 사용 O

    @GET("categories.php")
    suspend fun getMeals(
        // no query
    ) : MealsCategoriesResponse

}
