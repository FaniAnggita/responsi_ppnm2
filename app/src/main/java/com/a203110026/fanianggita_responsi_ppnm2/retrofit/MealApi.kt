package com.a203110026.fanianggita_responsi_ppnm2.retrofit

import com.a203110026.fanianggita_responsi_ppnm2.pojo.CategoryList
import com.a203110026.fanianggita_responsi_ppnm2.pojo.MealsByCategoryList
import com.a203110026.fanianggita_responsi_ppnm2.pojo.MealList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

    @GET("random.php")
    fun getRandomMeal(): Call<MealList>

    @GET("lookup.php?")
    fun getMealDetails(@Query("i") id: String): Call<MealList>

    @GET("filter.php?")
    fun getPopularItems(@Query("c") mealCategory: String): Call<MealsByCategoryList>

    @GET("categories.php")
    fun getCategories(): Call<CategoryList>

    @GET("filter.php")
    fun getMealsByCategory(@Query("c") categoryName: String): Call<MealsByCategoryList>
}