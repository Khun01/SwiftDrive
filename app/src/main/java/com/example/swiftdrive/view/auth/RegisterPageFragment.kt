package com.example.swiftdrive.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.repository.AuthRepository
import com.example.swiftdrive.databinding.FragmentRegisterPageBinding
import com.example.swiftdrive.pages.viewModel.AuthViewModel
import com.example.swiftdrive.viewModel.AuthViewModelFactory
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class RegisterPageFragment : Fragment() {

    private lateinit var binding: FragmentRegisterPageBinding
    private val authViewModel: AuthViewModel by viewModels {
        com.example.swiftdrive.viewModel.AuthViewModelFactory(AuthRepository(FirebaseAuth.getInstance()))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterPageBinding.inflate(inflater, container, false)
        observeRegistration()
        binding.registerBtn.setOnClickListener {
            val name = binding.fullNameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val confirmPassword = binding.confirmPasswordEditText.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && name.isNotEmpty()) {
                if (password == confirmPassword) {
                    authViewModel.registerUser(email, password)
                } else {
                    Toast.makeText(requireContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.loginTv.setOnClickListener {
            findNavController().navigate(R.id.action_registerPageFragment_to_loginPageFragment)
        }
        binding.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }

    private fun observeRegistration(){
        lifecycleScope.launch {
            authViewModel.authState.collect{ result ->
                result?.let { authResult ->
                    authResult
                        .onSuccess{
                            Toast.makeText(requireContext(), "Registration successful!", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_registerPageFragment_to_loginPageFragment)
                        }
                        .onFailure { exception ->
                            Toast.makeText(requireContext(), "Error: ${exception.message}", Toast.LENGTH_LONG).show()
                        }
                }
            }
        }
    }
}