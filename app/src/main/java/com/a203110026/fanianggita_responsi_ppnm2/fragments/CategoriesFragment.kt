package com.a203110026.fanianggita_responsi_ppnm2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.a203110026.fanianggita_responsi_ppnm2.activities.MainActivity
import com.a203110026.fanianggita_responsi_ppnm2.adapters.CategoriesAdapter
import com.a203110026.fanianggita_responsi_ppnm2.databinding.FragmentCategoriesBinding
import com.a203110026.fanianggita_responsi_ppnm2.mvvm.HomeViewModel

class CategoriesFragment : Fragment() {
    lateinit var binding: FragmentCategoriesBinding
    lateinit var categoriesAdapter: CategoriesAdapter
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        prepareRecyclerView()
        observeCategories()
    }

    private fun observeCategories() {
        viewModel.observeCategoriesLiveData().observe(viewLifecycleOwner) {categories ->
            categoriesAdapter.setCategoryList(categories)
        }
    }

    private fun prepareRecyclerView() {
        categoriesAdapter = CategoriesAdapter()
        binding.rvCategories.apply {
            layoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
            adapter = categoriesAdapter
        }
    }

}