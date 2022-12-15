package com.a203110026.fanianggita_responsi_ppnm2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.a203110026.fanianggita_responsi_ppnm2.adapters.CategoryMealsAdapter
import com.a203110026.fanianggita_responsi_ppnm2.databinding.ActivityCategoryMealsBinding
import com.a203110026.fanianggita_responsi_ppnm2.fragments.HomeFragment
import com.a203110026.fanianggita_responsi_ppnm2.mvvm.CategoriesMealsViewModel

class CategoryMealsActivity : AppCompatActivity() {

    lateinit var binding: ActivityCategoryMealsBinding
    lateinit var categoryMealsViewModel: CategoriesMealsViewModel
    lateinit var categoryMealsAdapter : CategoryMealsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryMealsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareRecyclerView()

        categoryMealsViewModel = ViewModelProvider(this)[CategoriesMealsViewModel:: class.java]

        categoryMealsViewModel.getMealsByCategory(intent.getStringExtra(HomeFragment.CATEGORY_NAME)!!)

        categoryMealsViewModel.observeCategoriesMealsLiveData().observe(this, Observer {
            mealList ->
            binding.tvCategoryCount.text = mealList.size.toString()
            categoryMealsAdapter.setMealList(mealList)
        })
    }

    private fun prepareRecyclerView() {
        categoryMealsAdapter = CategoryMealsAdapter()
        binding.rvMeals.apply {
            layoutManager = GridLayoutManager(context, 2,GridLayoutManager.VERTICAL, false)
            adapter = categoryMealsAdapter
        }
    }
}