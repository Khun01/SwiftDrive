package com.example.swiftdrive.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentLandingPageBinding
import com.example.swiftdrive.databinding.FragmentRegisterPageBinding

class RegisterPageFragment : Fragment() {
    private lateinit var binding: FragmentRegisterPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterPageBinding.inflate(inflater, container, false)
        binding.registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_registerPageFragment_to_loginPageFragment)
        }
        binding.loginTv.setOnClickListener {
            findNavController().navigate(R.id.action_registerPageFragment_to_loginPageFragment)
        }
        binding.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }
}