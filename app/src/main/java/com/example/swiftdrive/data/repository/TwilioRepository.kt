package com.example.swiftdrive.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.swiftdrive.data.model.TwilioResponse
import com.example.swiftdrive.network.ApiTwilioClient
import com.example.swiftdrive.network.ApiTwilioService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TwilioRepository() {

    private val service: ApiTwilioService = ApiTwilioClient.createTwilioService()

    private val _messageResponse = MutableLiveData<TwilioResponse>()
    val messageResponse: LiveData<TwilioResponse> get() = _messageResponse

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun sendWhatsAppOtp(otp: String, toNumber: String = "whatsapp:+639951849051") {
        val fromNumber = "whatsapp:+14155238886"
        val messageBody = "Your one-time password is: $otp"

        val call = service.sendWhatsAppMessage(
            ApiTwilioClient.ACCOUNT_SID,
            toNumber,
            fromNumber,
            messageBody
        )

        call.enqueue(object : Callback<TwilioResponse> {
            override fun onResponse(call: Call<TwilioResponse>, response: Response<TwilioResponse>) {
                if (response.isSuccessful) {
                    _messageResponse.postValue(response.body())
                } else {
                    _error.postValue("Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<TwilioResponse>, t: Throwable) {
                _error.postValue("Failed: ${t.message}")
            }
        })
    }
}
