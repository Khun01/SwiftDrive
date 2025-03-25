package com.example.swiftdrive.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swiftdrive.data.repository.AuthRepository
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _authState = MutableStateFlow<Result<AuthResult>?>(null)
    val authState: MutableStateFlow<Result<AuthResult>?> = _authState

    fun registerUser(email: String, password:String){
        viewModelScope.launch {
            Log.d("AuthViewModel", "Starting Registration Process...")
            authRepository.registerUser(email, password).collect { result ->
                _authState.value = result
                result.onSuccess { authResult ->
                    val user = authResult.user
                    Log.d("AuthViewModel", "User Registered: UID=${user?.uid}, Email=${user?.email}")
                }.onFailure { exception ->
                    Log.e("AuthViewModel", "Registration Failed: ${exception.message}")
                }
            }
        }
    }

    fun loginUser(email: String, password:String){
        viewModelScope.launch {
            Log.d("AuthViewModel", "Starting login Process...")
            authRepository.loginUser(email, password).collect { result ->
                _authState.value = result
                result.onSuccess { authResult ->
                    val user = authResult.user
                    Log.d("AuthViewModel", "User logged in: UID=${user?.uid}, Email=${user?.email}")
                }.onFailure { exception ->
                    Log.e("AuthViewModel", "logged in Failed: ${exception.message}")
                }
            }
        }
    }
}