package com.example.swiftdrive.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentTwoFactorAuthCompletedBinding

class TwoFactorAuthCompletedFragment : Fragment() {
    private lateinit var binding: FragmentTwoFactorAuthCompletedBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentTwoFactorAuthCompletedBinding.inflate(inflater, container, false)
        binding.continueToHomePageBtn.setOnClickListener {
            requireActivity().findNavController(R.id.navHostFragment).navigate(R.id.wrapperFragment)
        }
        return binding.root
    }
}