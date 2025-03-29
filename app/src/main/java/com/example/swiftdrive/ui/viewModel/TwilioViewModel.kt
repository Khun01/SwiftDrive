package com.example.swiftdrive.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swiftdrive.data.model.TwilioResponse
import com.example.swiftdrive.data.repository.TwilioRepository
import kotlinx.coroutines.launch

class TwilioViewModel(private val repository: TwilioRepository): ViewModel() {
    val messageResponse: LiveData<TwilioResponse> = repository.messageResponse
    val error: LiveData<String> = repository.error

    fun sendOtp(otp: String) {
        repository.sendWhatsAppOtp(otp)
    }
}