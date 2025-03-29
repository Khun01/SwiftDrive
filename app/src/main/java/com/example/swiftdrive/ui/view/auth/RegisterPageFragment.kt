package com.example.swiftdrive.ui.view.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.data.repository.AuthRepository
import com.example.swiftdrive.data.repository.TwilioRepository
import com.example.swiftdrive.databinding.FragmentRegisterPageBinding
import com.example.swiftdrive.ui.viewModel.AuthViewModel
import com.example.swiftdrive.ui.viewModel.AuthViewModelFactory
import com.example.swiftdrive.ui.viewModel.TwilioViewModel
import com.example.swiftdrive.ui.viewModel.TwilioViewModelFactory
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class RegisterPageFragment : Fragment() {

    private lateinit var binding: FragmentRegisterPageBinding
    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory(AuthRepository(FirebaseAuth.getInstance(), requireContext()))
    }

    private val twilioViewModel: TwilioViewModel by viewModels {
        TwilioViewModelFactory(TwilioRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterPageBinding.inflate(inflater, container, false)
        binding.registerBtn.setOnClickListener {
//            findNavController().navigate(R.id.action_registerPageFragment_to_emailVerificationPageFragment)
//            val name = binding.fullNameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            if (email.isNotEmpty()) {
                twilioViewModel.sendEmailVerification(email)
            } else {
                Toast.makeText(requireContext(), "Please enter an email", Toast.LENGTH_SHORT).show()
            }
//            val password = binding.passwordEditText.text.toString()
//            val confirmPassword = binding.confirmPasswordEditText.text.toString()
//            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && name.isNotEmpty()) {
//                if (password == confirmPassword) {
//                    authViewModel.registerUser(email, password)
//                } else {
//                    Toast.makeText(requireContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(requireContext(), "Please fill in all fields!", Toast.LENGTH_SHORT).show()
//            }
        }
        binding.loginTv.setOnClickListener {
            findNavController().navigate(R.id.action_registerPageFragment_to_loginPageFragment)
        }
        binding.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }

        observeRegistration()
        observeViewModel()
        return binding.root
    }

    private fun observeRegistration(){
        lifecycleScope.launch {
            authViewModel.authState.collect{ result ->
                result?.let { authResult ->
                    authResult
                        .onSuccess{
                            Toast.makeText(requireContext(), "Registration successful!", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_registerPageFragment_to_emailVerificationPageFragment)
                        }
                        .onFailure { exception ->
                            Toast.makeText(requireContext(), "Error: ${exception.message}", Toast.LENGTH_LONG).show()
                        }
                }
            }
        }
    }

    private fun observeViewModel() {
        twilioViewModel.emailSendResponse.observe(viewLifecycleOwner) { response ->
            Log.d("TwilioViewModel", "Email send response: ${response.status}")
            if (response.status == "success") {
                Toast.makeText(requireContext(), "Verification email sent!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Failed to send email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}