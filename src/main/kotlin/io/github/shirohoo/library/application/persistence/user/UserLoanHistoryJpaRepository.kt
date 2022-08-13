package io.github.shirohoo.library.application.persistence.user

import io.github.shirohoo.library.domain.user.UserLoanHistory
import io.github.shirohoo.library.domain.user.UserLoanStatus
import org.springframework.data.jpa.repository.JpaRepository

interface UserLoanHistoryJpaRepository : JpaRepository<UserLoanHistory, Long> {
    fun existsByBookTitleAndStatus(bookTitle: String, status: UserLoanStatus): Boolean
    fun findAllByStatus(status: UserLoanStatus): List<UserLoanHistory>
}
