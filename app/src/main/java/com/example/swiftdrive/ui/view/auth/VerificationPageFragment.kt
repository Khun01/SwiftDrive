package com.example.swiftdrive.ui.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentVerificationPageBinding

class VerificationPageFragment : Fragment() {
    private lateinit var binding: FragmentVerificationPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentVerificationPageBinding.inflate(inflater, container, false)
        binding.submitOtp.setOnClickListener {
            findNavController().navigate(R.id.action_verificationPageFragment_to_resetPasswordPageFragment)
        }
        binding.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }
}