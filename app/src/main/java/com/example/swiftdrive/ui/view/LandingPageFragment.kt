package com.example.swiftdrive.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentLandingPageBinding
import com.example.swiftdrive.data.repository.SharedPrefManager

class LandingPageFragment : Fragment() {
    private lateinit var binding: FragmentLandingPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLandingPageBinding.inflate(inflater, container, false)
        binding.getStarted.setOnClickListener {
            val sharedPrefManager = SharedPrefManager(requireContext())
            val token = sharedPrefManager.getToken()
            val userId = sharedPrefManager.getUserId()
            if(!token.isNullOrEmpty() && !userId.isNullOrEmpty()){
                findNavController().navigate(R.id.action_landingPageFragment_to_wrapperFragment)
            }else{
                findNavController().navigate(R.id.action_landingPageFragment_to_loginPageFragment)
            }
        }
        binding.register.setOnClickListener {
            findNavController().navigate(R.id.action_landingPageFragment_to_registerPageFragment)
        }
        return binding.root
    }
}