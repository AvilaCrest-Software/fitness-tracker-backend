package com.avilacrest.track_to_power.infrastructure.adapter.inbound.http.auth.model

data class LoginRequest(
    val email: String,
    val password: String
)