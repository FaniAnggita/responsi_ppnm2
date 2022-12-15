package com.a203110026.fanianggita_responsi_ppnm2.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.a203110026.fanianggita_responsi_ppnm2.pojo.Meal

@Dao
interface MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
 fun upsert(meal: Meal)

    @Delete
 fun delete(meal: Meal)

    @Query("SELECT * FROM mealInformation")
    fun getAllMeal(): LiveData<List<Meal>>
}