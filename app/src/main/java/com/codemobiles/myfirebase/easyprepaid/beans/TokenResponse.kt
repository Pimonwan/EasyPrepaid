package com.codemobiles.myfirebase.easyprepaid.beans

data class TokenResponse(
    val `data`: Data,
    val status: Status
)

data class Data(
    val accessToken: String,
    val expiresAt: Int,
    val expiresIn: Int,
    val tokenType: String
)

data class Status(
    val code: Int,
    val description: String
)