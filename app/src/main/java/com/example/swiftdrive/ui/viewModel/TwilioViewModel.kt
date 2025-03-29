package com.example.swiftdrive.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swiftdrive.data.model.TwilioResponse
import com.example.swiftdrive.data.repository.TwilioRepository
import kotlinx.coroutines.launch

class TwilioViewModel(private val repository: TwilioRepository): ViewModel() {
    private val _phoneNumberResponse = MutableLiveData<TwilioResponse>()
    val phoneNumberResponse: LiveData<TwilioResponse> get() = _phoneNumberResponse

    private val _verificationResponse = MutableLiveData<TwilioResponse>()
    val verificationResponse: LiveData<TwilioResponse> get() = _verificationResponse

    private val _emailSendResponse = MutableLiveData<TwilioResponse>()
    val emailSendResponse: LiveData<TwilioResponse> get() = _emailSendResponse

    fun sendOTP(phoneNumber: String) {
        viewModelScope.launch {
            try {
                val response = repository.sendOTP(phoneNumber)
                _phoneNumberResponse.postValue(response)
            } catch (e: Exception) {
                _phoneNumberResponse.postValue(TwilioResponse("failed"))
            }
        }
    }

    fun verifyOTP(phoneNumber: String, otp: String) {
        viewModelScope.launch {
            try {
                val response = repository.verifyOTP(phoneNumber, otp)
                _verificationResponse.postValue(response)
            } catch (e: Exception) {
                _verificationResponse.postValue(TwilioResponse("failed"))
            }
        }
    }

    fun sendEmailVerification(email: String) {
        viewModelScope.launch {
            try {
                val response = repository.sendEmailVerification(email)
                _emailSendResponse.postValue(response)
            } catch (e: Exception) {
                _emailSendResponse.postValue(TwilioResponse("failed"))
            }
        }
    }
}