package com.example.swiftdrive.pages.view.mainPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.swiftdrive.databinding.FragmentProfilePageBinding

class ProfilePageFragment : Fragment() {
    private lateinit var binding: FragmentProfilePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentProfilePageBinding.inflate(inflater, container, false)
        return binding.root
    }
}