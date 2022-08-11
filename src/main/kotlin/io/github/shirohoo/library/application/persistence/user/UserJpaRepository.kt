package io.github.shirohoo.library.application.persistence.user

import io.github.shirohoo.library.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserJpaRepository : JpaRepository<User, Long> {
    fun findByName(name: String): Optional<User>
}