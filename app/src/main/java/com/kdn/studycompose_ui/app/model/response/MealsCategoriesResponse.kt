package com.kdn.studycompose_ui.app.model.response


import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(
    @SerializedName("categories")
    val category : List<Category>
)

data class Category(
    @SerializedName("idCategory")
    val idCategory: String,
    @SerializedName("strCategory")
    val strCategory: String,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String,
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String
)