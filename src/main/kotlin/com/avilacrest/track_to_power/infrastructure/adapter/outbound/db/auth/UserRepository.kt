package com.avilacrest.track_to_power.infrastructure.adapter.outbound.db.auth

import com.avilacrest.track_to_power.domain.model.User
import org.springframework.stereotype.Service
import java.time.OffsetDateTime.now
import java.util.UUID

@Service
class UserRepository {

    private val users = mapOf(
        "gianni@tracktopower.com" to User(
            id = UUID.fromString("3a69fd2c-76e6-4a72-ab94-2adfd25312ec"),
            firstName = "Gianni",
            lastName = "Manilia",
            email = "gianni@tracktopower.com",
            hashedPassword = "\$2a\$10\$TvndhUrp1WOn7IDDddotteopYkqbrYvHZRbljxaFQo7kZ8qrTNw5a",
            createdAt = now(),
            updatedAt = now()
        ),
        "javier@tracktopower.com" to User(
            id = UUID.fromString("ea042523-223e-45dd-b1e8-de3edc2ea2da"),
            firstName = "Javier",
            lastName = "Vivas",
            email = "javier@tracktopower.com",
            hashedPassword = "\$2a\$10\$ghWikzppZogJOE/pUU5lju/sYh8fIrMI1FBmk6boGrV03J6aWx1GG",
            createdAt = now(),
            updatedAt = now()
        ),
        "patricia@tracktopower.com" to User(
            id = UUID.fromString("3392524f-2724-4ba6-be97-94b4933c53cc"),
            firstName = "Patricia",
            lastName = "Fernandez",
            email = "patricia@tracktopower.com",
            hashedPassword = "\$2a\$10\$xIpKmUr4pdr1C6iHheiJ8OSiwInSilkxvS9LZ909hPxEfq30SYbN2",
            createdAt = now(),
            updatedAt = now()
        )
    )

    fun findByEmail(email: String): User? {
        return users[email]
    }
}