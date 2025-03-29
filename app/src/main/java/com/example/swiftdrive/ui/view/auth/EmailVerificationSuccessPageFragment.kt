package com.example.swiftdrive.ui.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentEmailVerificationSuccessPageBinding

class EmailVerificationSuccessPageFragment : Fragment() {
    private lateinit var binding: FragmentEmailVerificationSuccessPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentEmailVerificationSuccessPageBinding.inflate(inflater, container, false)
        binding.proceedBtn.setOnClickListener {
            findNavController().navigate(R.id.action_emailVerificationSuccessPageFragment_to_loginPageFragment)
        }
        return binding.root
    }

}