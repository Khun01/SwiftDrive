package com.example.swiftdrive.ui.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentEmailVerificationPageBinding

class EmailVerificationPageFragment : Fragment() {
    private lateinit var binding: FragmentEmailVerificationPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentEmailVerificationPageBinding.inflate(inflater, container, false)
        binding.confirmBtn.setOnClickListener {
            findNavController().navigate(R.id.action_emailVerificationPageFragment_to_emailVerificationSuccessPageFragment)
        }
        return binding.root
    }
}