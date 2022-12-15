package com.a203110026.fanianggita_responsi_ppnm2.mvvm


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.a203110026.fanianggita_responsi_ppnm2.db.MealDatabase

class HomeViewModelFactory(private val mealDatabase: MealDatabase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return HomeViewModel(mealDatabase) as T
    }
}