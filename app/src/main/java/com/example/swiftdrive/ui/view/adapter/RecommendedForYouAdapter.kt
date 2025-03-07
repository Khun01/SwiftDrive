package com.example.swiftdrive.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftdrive.databinding.CardRecommendedForYouBinding
import com.example.swiftdrive.data.model.RecommendedForYou

class RecommendedForYouAdapter(private val recommendedForYouList: ArrayList<RecommendedForYou>): RecyclerView.Adapter<RecommendedForYouAdapter.ViewHolderClass>() {

    class ViewHolderClass(private val binding: CardRecommendedForYouBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(currentItem: RecommendedForYou){
            binding.vehicleName.text = currentItem.vehicleName
            binding.vehicleDescription.text = currentItem.vehicleDescription
            binding.vehicleRatings.text = currentItem.vehicleRatings
            binding.vehiclePrice.text = currentItem.vehiclePrice
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding = CardRecommendedForYouBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderClass(binding)
    }

    override fun getItemCount(): Int {
        return recommendedForYouList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = recommendedForYouList[position]
        holder.bind(currentItem)
    }
}