package com.example.swiftdrive.data.repository


import com.example.swiftdrive.data.model.TwilioResponse
import com.example.swiftdrive.network.ApiTwilioService
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RetrofitClient {
    private const val BASE_URL = "https://api.twilio.com/2010-04-01/"

    fun createTwilioService(accountSid: String, authToken: String): ApiTwilioService {
        val authHeader = Credentials.basic(accountSid, authToken) // Basic Auth

        val client = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        return retrofit.create(ApiTwilioService::class.java)
    }

    fun sendWhatsAppOtp(otp: String) {
        val accountSid = "ACb10b9b99662e6cbfb155c03f63e5e26f"
        val authToken = "02d4b695f0e1a8bcc755ae859da23a5b"
        val toNumber = "whatsapp:+639951849051"
        val fromNumber = "whatsapp:+14155238886"
        val messageBody = "{Your one time password is: ${otp}}"


        val service = createTwilioService(accountSid, authToken)

        val call = service.sendWhatsAppMessage(
            accountSid,
            Credentials.basic(accountSid, authToken),
            toNumber,
            fromNumber,
            messageBody
        )

        call.enqueue(object : Callback<TwilioResponse> {
            override fun onResponse(call: Call<TwilioResponse>, response: Response<TwilioResponse>) {
                if (response.isSuccessful) {
                    println("✅ Message sent! SID: ${response.body()?.sid}")
                } else {
                    println("❌ Error: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<TwilioResponse>, t: Throwable) {
                println("❌ Failed to send message: ${t.message}")
            }
        })
    }
//    fun generate2FACode(): String {
//        val code = (100000..999999).random() // Generates a 6-digit number
//        return code.toString()
//    }
}
