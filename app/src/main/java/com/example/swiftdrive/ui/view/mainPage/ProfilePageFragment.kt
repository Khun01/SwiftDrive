package com.example.swiftdrive.ui.view.mainPage

import android.content.Intent
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
import com.example.swiftdrive.data.repository.AuthRepository
import com.example.swiftdrive.databinding.FragmentProfilePageBinding
import com.example.swiftdrive.ui.view.MainActivity
import com.example.swiftdrive.ui.viewModel.AuthViewModel
import com.example.swiftdrive.ui.viewModel.AuthViewModelFactory
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class ProfilePageFragment : Fragment() {
    private lateinit var binding: FragmentProfilePageBinding
    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory(AuthRepository(FirebaseAuth.getInstance(), requireContext()))
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentProfilePageBinding.inflate(inflater, container, false)
        observeLogOut()
        binding.twoFactorAuth.setOnClickListener{
            findNavController().navigate(R.id.action_profilePageFragment_to_twoFactorAuthPageFragment)
        }
        binding.ln8.setOnClickListener {
            println("The logout button is clicked")
            authViewModel.logoutUser()
        }
        return binding.root
    }

    private fun observeLogOut(){
        lifecycleScope.launch {
            authViewModel.logoutState.collect{ result ->
                result?.let {
                    it.onSuccess{
                            Toast.makeText(requireContext(), "Log out successfully!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(requireContext(), MainActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                            requireActivity().finish()
                        }
                        .onFailure { exception ->
                            Toast.makeText(requireContext(), "Error: ${exception.message}", Toast.LENGTH_LONG).show()
                        }
                }
            }
        }
    }
}