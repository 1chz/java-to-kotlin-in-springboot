package io.github.shirohoo.library.application.persistence.user

import io.github.shirohoo.library.domain.user.UserLoanHistory
import org.springframework.data.jpa.repository.JpaRepository

interface UserLoanHistoryJpaRepository : JpaRepository<UserLoanHistory, Long> {
    fun existsByBookTitleAndIsReturn(bookTitle: String, isReturn: Boolean): Boolean
}