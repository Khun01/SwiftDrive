package com.example.swiftdrive.pages.view.mainPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swiftdrive.databinding.FragmentHomePageBinding
import com.example.swiftdrive.pages.view.adapter.AnnouncementAdapter
import com.example.swiftdrive.pages.view.adapter.MostPopularVehiclesAdapter
import com.example.swiftdrive.pages.view.adapter.RecommendedForYouAdapter
import com.example.swiftdrive.data.model.Announcement
import com.example.swiftdrive.data.model.MostPopularVehicles
import com.example.swiftdrive.data.model.RecommendedForYou

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

        val myLinearLayoutManager = object : LinearLayoutManager(requireContext()) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        binding.recommendedForYouRecyclerView.apply {
            layoutManager = myLinearLayoutManager
            adapter = recommendedForYouAdapter
        }
    }
}