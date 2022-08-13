package io.github.shirohoo.library.application.persistence.user

import io.github.shirohoo.library.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserJpaRepository : JpaRepository<User, Long> {
    fun findByName(name: String): User?

    @Query("select distinct u from User u join fetch u.userLoanHistories")
    fun findAllWithHistories(): List<User>
}