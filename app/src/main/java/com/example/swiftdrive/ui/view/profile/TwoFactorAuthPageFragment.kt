package com.example.swiftdrive.ui.view.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.data.repository.TwilioRepository
import com.example.swiftdrive.databinding.FragmentTwoFactorAuthPageBinding
import com.example.swiftdrive.ui.viewModel.TwilioViewModel
import com.example.swiftdrive.ui.viewModel.TwilioViewModelFactory

class TwoFactorAuthPageFragment : Fragment() {

    private lateinit var binding: FragmentTwoFactorAuthPageBinding
    private val viewModel: TwilioViewModel by viewModels {
        TwilioViewModelFactory(TwilioRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoFactorAuthPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phoneNumberResponse()
        binding.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.confirmBtn.setOnClickListener {
            sendPhoneNumber()
        }
    }

    private fun sendPhoneNumber(){
        val phoneNumber = binding.phoneNumberEditText.text.toString()
        if (phoneNumber.isNotEmpty()) {
            val bundle = Bundle()
//            viewModel.sendOTP(phoneNumber)
//            bundle.putString("phoneNumber", phoneNumber)
//            findNavController().navigate(R.id.action_twoFactorAuthPageFragment_to_twoFactoAuthOtpFragment, bundle)
        } else {
            Toast.makeText(context, "Enter a valid phone number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun phoneNumberResponse() {
        viewModel.phoneNumberResponse.observe(viewLifecycleOwner) { response ->
            Log.d("PhoneResponse", "Response: $response") // Logs the full response object

            if (response.status == "success") {
                Log.d("PhoneResponse", "OTP sent successfully!") // Logs success message
                Toast.makeText(requireContext(), "OTP sent successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Log.e("PhoneResponse", "Failed to send OTP: $response") // Logs error message
                Toast.makeText(requireContext(), "Failed to send OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }

}