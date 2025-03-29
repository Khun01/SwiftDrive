package com.example.swiftdrive.data.repository

import com.example.swiftdrive.data.model.TwilioResponse
import com.example.swiftdrive.network.ApiTwilioClient

class TwilioRepository {
    private val serviceSid = "VAb13eaf337fad809fd2fe02ad907c7f3c"

    suspend fun sendOTP(phoneNumber: String): TwilioResponse {
        return ApiTwilioClient.api.sendOTP(serviceSid, phoneNumber)
    }

    suspend fun verifyOTP(phoneNumber: String, otp: String): TwilioResponse {
        return ApiTwilioClient.api.verifyOTP(serviceSid, phoneNumber, otp)
    }

    suspend fun sendEmailVerification(email: String): TwilioResponse {
        return ApiTwilioClient.api.sendEmailVerification(serviceSid, email)
    }
}