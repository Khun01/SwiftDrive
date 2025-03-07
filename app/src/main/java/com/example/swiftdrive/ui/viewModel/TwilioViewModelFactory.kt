package com.example.swiftdrive.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.swiftdrive.data.repository.TwilioRepository

class TwilioViewModelFactory(private val repository: TwilioRepository) : ViewModelProvider.Factory  {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TwilioViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TwilioViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}