package com.example.swiftdrive.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentForgotPasswordPageBinding

class ForgotPasswordPageFragment : Fragment() {
    private lateinit var binding: FragmentForgotPasswordPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForgotPasswordPageBinding.inflate(inflater, container, false)
        binding.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.sendEmail.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordPageFragment_to_verificationPageFragment)
        }
        return binding.root
    }
}