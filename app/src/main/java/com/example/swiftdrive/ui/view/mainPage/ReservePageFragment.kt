package com.example.swiftdrive.ui.view.mainPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swiftdrive.databinding.FragmentReservePageBinding
import com.example.swiftdrive.ui.view.adapter.RecommendedForYouAdapter
import com.example.swiftdrive.data.model.RecommendedForYou

class ReservePageFragment : Fragment() {
    private lateinit var binding: FragmentReservePageBinding

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
        binding = FragmentReservePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recommendedForYouAdapter = RecommendedForYouAdapter(recommendedForYouList)
        binding.recommendedForYouRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = recommendedForYouAdapter
        }
    }
}