package com.example.swiftdrive.model.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftdrive.databinding.CardMostPopularVehicleBinding
import com.example.swiftdrive.model.data.MostPopularVehicles

class MostPopularVehiclesAdapter(private val mostPopularVehiclesList: ArrayList<MostPopularVehicles>): RecyclerView.Adapter<MostPopularVehiclesAdapter.ViewHolderClass>() {

    class ViewHolderClass(private val binding: CardMostPopularVehicleBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(currentItem: MostPopularVehicles){
            binding.vehicleName.text = currentItem.vehicleName
            binding.vehicleBrand.text = currentItem.vehicleBrand
            binding.vehicleRatings.text = currentItem.vehicleRatings
            binding.vehiclePrice.text = currentItem.vehiclePrice
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding = CardMostPopularVehicleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderClass(binding)
    }

    override fun getItemCount(): Int {
        return mostPopularVehiclesList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = mostPopularVehiclesList[position]
        holder.bind(currentItem)
    }
}