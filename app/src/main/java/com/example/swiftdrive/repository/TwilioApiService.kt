package com.example.swiftdrive.repository

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

        fun create(accountSid: String, authToken: String): TwilioApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("$BASE_URL$accountSid/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(TwilioApiService::class.java)
        }
    }
}