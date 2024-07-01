package com.avilacrest.track_to_power.domain.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.OffsetDateTime
import java.util.UUID

data class User(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String,
    val hashedPassword: String,
    val createdAt: OffsetDateTime,
    val updatedAt: OffsetDateTime
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority> = emptyList()

    override fun getPassword(): String = hashedPassword

    override fun getUsername(): String = email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true

}