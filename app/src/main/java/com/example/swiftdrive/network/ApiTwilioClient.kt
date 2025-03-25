package com.example.swiftdrive.network

import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiTwilioClient {
    private const val BASE_URL = "https://verify.twilio.com/v2/Services/"
    private const val ACCOUNT_SID = "ACb10b9b99662e6cbfb155c03f63e5e26f"
    private const val AUTH_TOKEN = "b3b384656db6335a1da62c972b3da739"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .header("Authorization", Credentials.basic(ACCOUNT_SID, AUTH_TOKEN))
                .build()
            chain.proceed(request)
        }
        .build()

    val api: ApiTwilioService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiTwilioService::class.java)
}