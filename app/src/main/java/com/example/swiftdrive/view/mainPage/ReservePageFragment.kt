package com.example.swiftdrive.view.mainPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentReservePageBinding

class ReservePageFragment : Fragment() {
    private lateinit var binding: FragmentReservePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentReservePageBinding.inflate(inflater, container, false)
        return binding.root
    }
}