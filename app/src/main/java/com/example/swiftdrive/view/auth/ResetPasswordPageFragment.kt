package com.example.swiftdrive.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentResetPasswordPageBinding

class ResetPasswordPageFragment : Fragment() {
    private lateinit var binding: FragmentResetPasswordPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentResetPasswordPageBinding.inflate(inflater, container, false)
        return binding.root
    }
}