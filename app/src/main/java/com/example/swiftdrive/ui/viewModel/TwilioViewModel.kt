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
}