package io.github.shirohoo.library.application.persistence.user

import io.github.shirohoo.library.domain.user.User
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Long> {
    fun findByName(name: String): User?

    @EntityGraph(attributePaths = ["userLoanHistories"])
    override fun findAll(): List<User>
}