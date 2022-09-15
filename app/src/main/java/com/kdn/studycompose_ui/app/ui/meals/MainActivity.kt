package com.kdn.studycompose_ui.app.ui.meals

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kdn.studycompose_ui.app.model.response.Category
import com.kdn.studycompose_ui.app.model.response.MealsCategoriesResponse
import com.kdn.studycompose_ui.app.ui.theme.StudyCompose_UITheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val viewModel by viewModels<MealsCategoriesViewModel>()

        setContent{
            StudyCompose_UITheme {
                Surface {

                    MealsCategoriesScreen(name = "Hello")
                }
            }
        }

    }

    /* 밑에서 선언해준 viewmodel 의 객체는 composable 이 구성가능한
     수명동안 지속되며 항상 인스턴스화 되지 않는다. */

    /* 즉 viewmodel 이 필요한 content 가 해당 composable 을 가져다 쓴다면
    이 viewmodel 은 항상 살아있게된다.
     */

    @Composable
    fun MealsCategoriesScreen(name: String) {
      val viewModel : MealsCategoriesViewModel = viewModel()

      val rememberedMeals : MutableState<List<Category>>
                    = remember { mutableStateOf(emptyList<Category>())}


      val coroutineScope = rememberCoroutineScope()

        /*
        viewModel.getMeals{response ->
            val mealsFromApiValue = response!!.categories
            rememberedMeals.value = mealsFromApiValue
        }*/

        LaunchedEffect(key1 = "GET_MEALS"){
            coroutineScope.launch(Dispatchers.IO) {

                val meals = viewModel.getMeals()

                rememberedMeals.value = meals.category
            }

        }

        LazyColumn{
            items(rememberedMeals.value){ meals ->
                Text(text = meals.strCategory)
            }
        }
    }
}