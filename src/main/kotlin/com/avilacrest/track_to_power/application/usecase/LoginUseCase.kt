package com.avilacrest.track_to_power.application.usecase

import com.avilacrest.track_to_power.application.service.JwtService
import com.avilacrest.track_to_power.infrastructure.adapter.outbound.db.auth.UserRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class LoginUseCase(
    private val userRepository: UserRepository,
    private val authenticationManager: AuthenticationManager,
    private val jwtService: JwtService,
    private val passwordEncoder: PasswordEncoder
) {

    fun execute(loginUseCaseInput: LoginUseCaseInput): LoginUseCaseOutput {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                loginUseCaseInput.email,
                loginUseCaseInput.password
            )
        )

        val user = userRepository.findByEmail(loginUseCaseInput.email)
            ?: throw UsernameNotFoundException("User not found")

        return LoginUseCaseOutput(
            token = jwtService.generateToken(user),
            expiresIn = jwtService.getExpirationTime()
        )
    }
}

data class LoginUseCaseInput(
    val email: String,
    val password: String
)

data class LoginUseCaseOutput(
    val token: String,
    val expiresIn: Long
)