package com.a203110026.fanianggita_responsi_ppnm2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.a203110026.fanianggita_responsi_ppnm2.databinding.PopularItemsBinding
import com.a203110026.fanianggita_responsi_ppnm2.pojo.MealsByCategory

class MostPopularAdapter(): RecyclerView.Adapter<MostPopularAdapter.PopularMealViewHolder>() {
    lateinit var onItemClick: ((MealsByCategory) -> Unit)
    var mealList = ArrayList<MealsByCategory>()

    fun setMeals(mealList: ArrayList<MealsByCategory>) {
        this.mealList = mealList
        notifyDataSetChanged()
    }

    class PopularMealViewHolder(val binding: PopularItemsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMealViewHolder {
        return PopularMealViewHolder(PopularItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PopularMealViewHolder, position: Int) {
       Glide.with(holder.itemView)
           .load(mealList[position].strMealThumb)
           .into(holder.binding.imgPopularMealItem)

        holder.itemView.setOnClickListener {
           onItemClick.invoke(mealList[position])
        }
    }

    override fun getItemCount(): Int {
       return mealList.size
    }

}