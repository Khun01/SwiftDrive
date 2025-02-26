package com.example.swiftdrive.model.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.CardAnnouncementBinding
import com.example.swiftdrive.model.data.Announcement

class AnnouncementAdapter(private val announcementList: ArrayList<Announcement>): RecyclerView.Adapter<AnnouncementAdapter.ViewHolderClass>() {

    class ViewHolderClass(private val binding: CardAnnouncementBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(currentItem: Announcement){
            binding.headingAnnouncement.text = currentItem.heading
            binding.subHeadingAnnouncement.text = currentItem.subHeading
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val binding = CardAnnouncementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderClass(binding)
    }

    override fun getItemCount(): Int {
        return announcementList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = announcementList[position]
        holder.bind(currentItem)
    }
}