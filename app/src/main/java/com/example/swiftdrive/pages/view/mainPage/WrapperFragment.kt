package com.example.swiftdrive.pages.view.mainPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import androidx.navigation.ui.setupWithNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentWrapperBinding

class WrapperFragment : Fragment() {
    private lateinit var binding: FragmentWrapperBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWrapperBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.mainFragmentContainer) as NavHostFragment
        val navController = navHostFragment.navController

        val navGraph = navController.createGraph(startDestination = R.id.homePageFragment) {
            fragment<HomePageFragment>(R.id.homePageFragment)
            fragment<ReservePageFragment>(R.id.reservePageFragment)
            fragment<MapPageFragment>(R.id.mapPageFragment)
            fragment<ProfilePageFragment>(R.id.profilePageFragment)
        }

        navController.graph = navGraph

        binding.bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.profilePageFragment) {
                binding.toolbar.visibility = View.GONE
                binding.v1.visibility = View.GONE
            } else {
                binding.toolbar.visibility = View.VISIBLE
                binding.v1.visibility = View.VISIBLE
            }
        }
    }
}