package io.github.shirohoo.library.application.persistence.user

import io.github.shirohoo.library.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Long>, UserQueryRepository {
    fun findByName(name: String): User?
}