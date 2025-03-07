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
import androidx.navigation.fragment.navArgs
import com.example.swiftdrive.R
import com.example.swiftdrive.data.repository.TwilioRepository
import com.example.swiftdrive.databinding.FragmentTwoFactorAuthOtpBinding
import com.example.swiftdrive.ui.viewModel.TwilioViewModel
import com.example.swiftdrive.ui.viewModel.TwilioViewModelFactory

class TwoFactorAuthOtpFragment() : Fragment() {

    private lateinit var binding: FragmentTwoFactorAuthOtpBinding
    private val viewModel: TwilioViewModel by viewModels {
        TwilioViewModelFactory(TwilioRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentTwoFactorAuthOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.confirmBtn.setOnClickListener {
//            findNavController().navigate(R.id.action_twoFactoAuthOtpFragment_to_twoFactorAuthCompletedFragment)
            verifyOtp()
        }
        binding.backArrow.setOnClickListener {
            findNavController().navigateUp()
        }

//        val editTexts = listOf(otp1, otp2, otp3, otp4)
//
//        for (i in editTexts.indices) {
//            editTexts[i].addTextChangedListener(object : TextWatcher {
//                override fun afterTextChanged(s: Editable?) {
//                    if (s?.length == 1 && i < editTexts.size - 1) {
//                        editTexts[i + 1].requestFocus()
//                    }
//                }
//                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
//                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
//            })
//        }
    }

    private fun verifyOtp(){
        val otp1 = binding.code1.text.toString()
        val otp2 = binding.code1.text.toString()
        val otp3 = binding.code1.text.toString()
        val otp4 = binding.code1.text.toString()
        val otp = "$otp1$otp2$otp3$otp4"

        if (otp.isNotEmpty()) {
            val phoneNumber = arguments?.getString("phoneNumber")
            Log.d("Phone number", phoneNumber.toString())
//            viewModel.verifyOTP(phoneNumber!!, otp)
        } else {
            Toast.makeText(context, "Enter the OTP", Toast.LENGTH_SHORT).show()
        }
    }

    private fun verificationResponse(){
        viewModel.verificationResponse.observe(viewLifecycleOwner) { response ->
            if (response.status == "success") {
                Toast.makeText(requireContext(), "OTP sent successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Failed to send OTP", Toast.LENGTH_SHORT).show()
            }
        }
    }
}