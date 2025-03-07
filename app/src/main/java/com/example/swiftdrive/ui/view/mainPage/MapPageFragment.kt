package com.example.swiftdrive.ui.view.mainPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.swiftdrive.databinding.FragmentMapPageBinding

class MapPageFragment : Fragment() {
    private lateinit var binding: FragmentMapPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapPageBinding.inflate(inflater, container, false)
        return binding.root
    }
}