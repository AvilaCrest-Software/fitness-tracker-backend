package com.avilacrest.track_to_power.infrastructure.adapter.inbound.http.auth.model

data class LoginResponse(
    val token: String,
    val expiresIn: Long
)