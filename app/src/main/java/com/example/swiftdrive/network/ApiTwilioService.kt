package com.example.swiftdrive.network

import com.example.swiftdrive.data.model.TwilioResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiTwilioService {
    @FormUrlEncoded
    @POST("{serviceSid}/Verifications")
    suspend fun sendOTP(
        @Path("serviceSid") serviceSid: String,
        @Field("To") phoneNumber: String,
        @Field("Channel") channel: String = "sms"
    ): TwilioResponse

    @FormUrlEncoded
    @POST("{serviceSid}/VerificationCheck")
    suspend fun verifyOTP(
        @Path("serviceSid") serviceSid: String,
        @Field("To") phoneNumber: String,
        @Field("Code") otp: String
    ): TwilioResponse

    @FormUrlEncoded
    @POST("{serviceSid}/Verifications")
    suspend fun sendEmailVerification(
        @Path("serviceSid") serviceSid: String,
        @Field("To") email: String,
        @Field("Channel") channel: String = "email"
    ): TwilioResponse
}