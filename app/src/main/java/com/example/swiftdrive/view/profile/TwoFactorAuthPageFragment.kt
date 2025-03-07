package com.example.swiftdrive.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentTwoFactorAuthPageBinding

class TwoFactorAuthPageFragment : Fragment() {
    private lateinit var binding: FragmentTwoFactorAuthPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoFactorAuthPageBinding.inflate(inflater, container, false)
        binding.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.confirmBtn.setOnClickListener {
            findNavController().navigate(R.id.action_twoFactorAuthPageFragment_to_twoFactoAuthOtpFragment)
        }
        return binding.root
    }
}