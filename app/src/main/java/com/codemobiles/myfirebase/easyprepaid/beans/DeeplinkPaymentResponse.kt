package com.codemobiles.myfirebase.hackatonpractice

import com.google.gson.annotations.SerializedName

data class DeeplinkPaymentResponse(
    @SerializedName("data")
    val data: Data,
    @SerializedName("status")
    val status: Status
) {
    data class Data(
        @SerializedName("transactionId")
        val transactionId: String,
        @SerializedName("deeplinkUrl")
        val deeplinkUrl: String,
        @SerializedName("userRefId")
        val userRefId: String
    )

    data class Status(
        @SerializedName("code")
        val code: Long,
        @SerializedName("description")
        val description: String
    )
}