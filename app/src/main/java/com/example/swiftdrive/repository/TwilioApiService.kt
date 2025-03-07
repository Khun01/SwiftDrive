package com.example.swiftdrive.repository

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TwilioApiService {
    @FormUrlEncoded
    @POST("Messages.json")
    fun sendOtp(
        @Field("To") to:String,
        @Field("From") from: String,
        @Field("Body") body: String
    ): Call<Unit>

    companion object{
        private const val BASE_URL = "https://verify.twilio.com/v2/Services/VAb13eaf337fad809fd2fe02ad907c7f3c"
    }
}