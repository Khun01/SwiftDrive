package com.example.swiftdrive.view.mainPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentHomePageBinding
import com.example.swiftdrive.databinding.FragmentLoginPageBinding
import com.example.swiftdrive.model.adapter.AnnouncementAdapter
import com.example.swiftdrive.model.adapter.MostPopularVehiclesAdapter
import com.example.swiftdrive.model.adapter.RecommendedForYouAdapter
import com.example.swiftdrive.model.data.Announcement
import com.example.swiftdrive.model.data.MostPopularVehicles
import com.example.swiftdrive.model.data.RecommendedForYou

class HomePageFragment : Fragment() {

    private lateinit var binding: FragmentHomePageBinding

    private val announcementList = arrayListOf(
        Announcement("20% on All SUV Rentals!", "Book now and save big on your next ride!"),
        Announcement("20% on All SUV Rentals!", "Book now and save big on your next ride!"),
        Announcement("20% on All SUV Rentals!", "Book now and save big on your next ride!"),
        Announcement("20% on All SUV Rentals!", "Book now and save big on your next ride!"),
    )

    private val mostPopularVehiclesList = arrayListOf(
        MostPopularVehicles("2019 Macan", "Porsche", "4.2", "110"),
        MostPopularVehicles("2019 Macan", "Porsche", "4.5", "890"),
        MostPopularVehicles("2019 Macan", "Porsche", "4.1", "270"),
        MostPopularVehicles("2019 Macan", "Porsche", "4.9", "210"),
    )

    private val recommendedForYouList = arrayListOf(
        RecommendedForYou("2019 Macan", "The Macan is currently the best-selling model in Porsche’s UK range. Last year more examples of the SUV were sold than the c . . .", "4.2", "200"),
        RecommendedForYou("2019 Macan", "The Macan is currently the best-selling model in Porsche’s UK range. Last year more examples of the SUV were sold than the c . . .", "4.2", "200"),
        RecommendedForYou("2019 Macan", "The Macan is currently the best-selling model in Porsche’s UK range. Last year more examples of the SUV were sold than the c . . .", "4.2", "200"),
        RecommendedForYou("2019 Macan", "The Macan is currently the best-selling model in Porsche’s UK range. Last year more examples of the SUV were sold than the c . . .", "4.2", "200"),
        RecommendedForYou("2019 Macan", "The Macan is currently the best-selling model in Porsche’s UK range. Last year more examples of the SUV were sold than the c . . .", "4.2", "200"),
        RecommendedForYou("2019 Macan", "The Macan is currently the best-selling model in Porsche’s UK range. Last year more examples of the SUV were sold than the c . . .", "4.2", "200"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val announcementAdapter = AnnouncementAdapter(announcementList)
        val mostPopularVehicleAdapter = MostPopularVehiclesAdapter(mostPopularVehiclesList)

        val limitedRecommendedForYouList = ArrayList(recommendedForYouList.take(5))
        val recommendedForYouAdapter = RecommendedForYouAdapter(limitedRecommendedForYouList)
        binding.announcementRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = announcementAdapter
        }
        binding.mostPopularVehicleRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mostPopularVehicleAdapter
        }
        binding.recommendedForYouRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recommendedForYouAdapter
        }
    }
}