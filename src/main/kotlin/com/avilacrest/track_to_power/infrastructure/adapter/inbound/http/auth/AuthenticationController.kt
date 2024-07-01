package com.avilacrest.track_to_power.infrastructure.adapter.inbound.http.auth

import com.avilacrest.track_to_power.application.usecase.LoginUseCase
import com.avilacrest.track_to_power.application.usecase.LoginUseCaseInput
import com.avilacrest.track_to_power.infrastructure.adapter.inbound.http.auth.model.LoginRequest
import com.avilacrest.track_to_power.infrastructure.adapter.inbound.http.auth.model.LoginResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class AuthenticationController(private val loginUseCase: LoginUseCase) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<LoginResponse> {
        val loginUseCaseInput = LoginUseCaseInput(
            email = loginRequest.email,
            loginRequest.password
        )
        val loginUseCaseOutput = loginUseCase.execute(loginUseCaseInput)

        val loginResponse = LoginResponse(
            token = loginUseCaseOutput.token,
            expiresIn = loginUseCaseOutput.expiresIn
        )

        return ResponseEntity.ok(loginResponse)
    }
}