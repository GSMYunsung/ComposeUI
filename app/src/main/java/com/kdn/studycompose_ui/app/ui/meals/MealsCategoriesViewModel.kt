package com.kdn.studycompose_ui.app.ui.meals

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kdn.studycompose_ui.app.model.MealsRepository
import com.kdn.studycompose_ui.app.model.response.Category
import com.kdn.studycompose_ui.app.model.response.MealsCategoriesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MealsCategoriesViewModel @Inject constructor (
    private val repository: MealsRepository
) : ViewModel() {

     suspend fun getMeals() : MealsCategoriesResponse{
        return repository.getMeals()
     }
}