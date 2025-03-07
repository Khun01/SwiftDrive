package com.example.swiftdrive.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentTwoFactoAuthOtpBinding

class TwoFactoAuthOtpFragment : Fragment() {
    private lateinit var binding: FragmentTwoFactoAuthOtpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentTwoFactoAuthOtpBinding.inflate(inflater, container, false)
        binding.confirmBtn.setOnClickListener {
            findNavController().navigate(R.id.action_twoFactoAuthOtpFragment_to_twoFactorAuthCompletedFragment)
        }
        binding.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }
}