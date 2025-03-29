package com.example.swiftdrive.network

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiTwilioClient {
    private const val BASE_URL = "https://api.twilio.com/2010-04-01/"
    const val ACCOUNT_SID = "ACb10b9b99662e6cbfb155c03f63e5e26f"
    const val AUTH_TOKEN = "eba3462bd66c0c87fedd9f034c17e3b5"

    private val authInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Authorization", Credentials.basic(ACCOUNT_SID, AUTH_TOKEN))
            .build()
        chain.proceed(request)
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()

    fun createTwilioService(): ApiTwilioService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(ApiTwilioService::class.java)
    }
}