package com.example.swiftdrive.ui.view.mainPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentWhatsAppOtpBinding

class WhatsAppOtpFragment : Fragment() {
    private lateinit var binding: FragmentWhatsAppOtpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentWhatsAppOtpBinding.inflate(inflater, container, false)
        val otp = arguments?.getString("otp")
        binding.btnSubmitOtp.setOnClickListener {
            val inputOtp = binding.etOtp.text.toString()
            println("The otp is: $otp")
            if (otp == inputOtp){
                findNavController().navigate(R.id.action_whatsAppOtpFragment_to_wrapperFragment)
            }else{
                println("Laos")
            }
        }
        return binding.root
    }
}