package com.codemobiles.myfirebase.easyprepaid.model

import com.codemobiles.myfirebase.easyprepaid.beans.TokenBody
import com.codemobiles.myfirebase.easyprepaid.beans.TokenResponse
import com.codemobiles.myfirebase.hackatonpractice.DeeplinkBody
import com.codemobiles.myfirebase.hackatonpractice.DeeplinkPaymentResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ScbHttpClient {
    @Headers(
        "resourceOwnerId: ee14425c-9299-4214-ac74-4e303c1125da",
        "requestUId: c385f890-ba04-4973-9939-98ce407ed740",
        "Content-Type: application/json")
    @POST("/partners/sandbox/v1/oauth/token")
    fun getAccessToken(@Body body: TokenBody): Call<TokenResponse>

//    @Headers(
//        "Content-Type: application/json",
//        "resourceOwnerId: ee14425c-9299-4214-ac74-4e303c1125da",
//        "requestUId: c385f890-ba04-4973-9939-98ce407ed740",
//        "channel: scbeasy",
//        "accept-language: EN")
//    @POST("/partners/sandbox/v2/deeplink/transactions")
//    fun getDeeplinkPayment(
//        @Header("authorization") authorize: String,
//        @Body body: DeeplinkForPaymentBody
//    ): Call<DeeplinkForPaymentResponse>

    @Headers(
        "Content-Type: application/json",
        "resourceOwnerId: ee14425c-9299-4214-ac74-4e303c1125da",
        "requestUId: c385f890-ba04-4973-9939-98ce407ed740",
        "channel: scbeasy",
        "accept-language: EN")
    @POST("/partners/sandbox/v2/deeplink/transactions")
    fun getDeeplink(
        @Header("authorization") authorize: String,
        @Body body: DeeplinkBody
    ): Call<DeeplinkPaymentResponse>

    companion object {
        val BASE_URL = "https://api.partners.scb"
        fun create(): ScbHttpClient {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ScbHttpClient::class.java)
        }
    }

}