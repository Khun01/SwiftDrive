package com.example.swiftdrive.ui.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.swiftdrive.R
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.data.repository.AuthRepository
import com.example.swiftdrive.data.repository.RetrofitClient
import com.example.swiftdrive.databinding.FragmentLoginPageBinding
import com.example.swiftdrive.ui.viewModel.AuthViewModel
import com.example.swiftdrive.ui.viewModel.AuthViewModelFactory
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class LoginPageFragment : Fragment() {

    private  lateinit var  binding: FragmentLoginPageBinding
    lateinit var otp: String

    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory(AuthRepository(FirebaseAuth.getInstance(), requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLoggedIn()
        binding.register.setOnClickListener {
            findNavController().navigate(R.id.action_loginPageFragment_to_registerPageFragment)
        }
        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginPageFragment_to_forgotPasswordPageFragment)
        }
        binding.loginBtn.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            authViewModel.loginUser(email, password)
            otp = this.generate2FACode();
            RetrofitClient.sendWhatsAppOtp(otp);
        }
        binding.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun observeLoggedIn(){
        lifecycleScope.launch {
            authViewModel.authState.collect{ result ->
                result?.let { authResult ->
                    authResult
                        .onSuccess{
                            Toast.makeText(requireContext(), "Logged in successful!", Toast.LENGTH_SHORT).show()
                            val bundle = Bundle()
                            bundle.putString("otp", otp)
                            println("Bundle ${bundle.keySet()}")
                            findNavController().navigate(R.id.action_loginPageFragment_to_whatsAppOtpFragment, bundle)
//                            findNavController().navigate(R.id.action_loginPageFragment_to_wrapperFragment)
                        }
                        .onFailure { exception ->
                            print(exception.message)
                            Toast.makeText(requireContext(), "Error: ${exception.message}", Toast.LENGTH_LONG).show()
                        }
                }
            }
        }
    }

    private fun generate2FACode(): String {
        val code = (100000..999999).random()
        println("generate: $code")
        return code.toString()
    }
}