package com.a203110026.fanianggita_responsi_ppnm2.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a203110026.fanianggita_responsi_ppnm2.pojo.MealsByCategory
import com.a203110026.fanianggita_responsi_ppnm2.pojo.MealsByCategoryList
import com.a203110026.fanianggita_responsi_ppnm2.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoriesMealsViewModel: ViewModel() {

    val mealsLiveData = MutableLiveData<List<MealsByCategory>>()

    fun getMealsByCategory(categoryName: String) {
        RetrofitInstance.api.getMealsByCategory(categoryName).enqueue(object : Callback<MealsByCategoryList> {
            override fun onResponse(
                call: Call<MealsByCategoryList>,
                response: Response<MealsByCategoryList>
            ) {
                response.body()?.let {
                    mealsList -> mealsLiveData.value = mealsList.meals
                }
            }

            override fun onFailure(call: Call<MealsByCategoryList>, t: Throwable) {
                Log.e("CategoryMealsViewModel", t.message.toString())
            }

        })
    }

    fun observeCategoriesMealsLiveData() : LiveData<List<MealsByCategory>> {
        return mealsLiveData
    }
}