package com.example.swiftdrive.view.mainPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentProfilePageBinding

class ProfilePageFragment : Fragment() {
    private lateinit var binding: FragmentProfilePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentProfilePageBinding.inflate(inflater, container, false)
        binding.twoFactorAuth.setOnClickListener{
            findNavController().navigate(R.id.action_profilePageFragment_to_twoFactorAuthPageFragment)
        }
        return binding.root
    }
}