package com.example.swiftdrive.data.model

import com.google.gson.annotations.SerializedName

data class TwilioResponse(
    @SerializedName("sid")
    val sid: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("error_message")
    val error_message: String?
)