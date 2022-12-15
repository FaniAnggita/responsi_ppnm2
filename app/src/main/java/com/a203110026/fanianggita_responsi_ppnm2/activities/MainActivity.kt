package com.a203110026.fanianggita_responsi_ppnm2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.a203110026.fanianggita_responsi_ppnm2.R
import com.a203110026.fanianggita_responsi_ppnm2.databinding.ActivityMainBinding
import com.a203110026.fanianggita_responsi_ppnm2.db.MealDatabase
import com.a203110026.fanianggita_responsi_ppnm2.mvvm.HomeViewModel
import com.a203110026.fanianggita_responsi_ppnm2.mvvm.HomeViewModelFactory

class MainActivity : AppCompatActivity() {

    val viewModel: HomeViewModel by lazy {
        val mealDatabase = MealDatabase.getInstance(this)
        val homeViewModelFactory = HomeViewModelFactory(mealDatabase)
        ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]
    }
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.btmNav
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)

        NavigationUI.setupWithNavController(bottomNavigationView,navController)
    }
}