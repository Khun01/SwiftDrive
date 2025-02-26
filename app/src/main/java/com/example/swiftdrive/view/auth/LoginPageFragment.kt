package com.example.swiftdrive.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.swiftdrive.R
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.databinding.FragmentLoginPageBinding

class LoginPageFragment : Fragment() {
    private  lateinit var  binding: FragmentLoginPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.register.setOnClickListener {
            findNavController().navigate(R.id.action_loginPageFragment_to_registerPageFragment)
        }
        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginPageFragment_to_forgotPasswordPageFragment)
        }
        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginPageFragment_to_wrapperFragment)
        }
        binding.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}