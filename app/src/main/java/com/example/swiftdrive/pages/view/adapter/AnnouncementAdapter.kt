package com.example.swiftdrive.pages.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftdrive.databinding.CardAnnouncementBinding
import com.example.swiftdrive.data.model.Announcement

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