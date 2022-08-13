package io.github.shirohoo.library.application.persistence.user

import io.github.shirohoo.library.domain.user.UserLoanHistory
import io.github.shirohoo.library.domain.user.UserLoanHistoryRepository
import io.github.shirohoo.library.domain.user.UserLoanStatus
import org.springframework.stereotype.Repository

@Repository
class UserLoanHistoryRepositoryImpl(
    private val jpaRepository: UserLoanHistoryJpaRepository
) : UserLoanHistoryRepository {
    override fun existsBy(bookTitle: String, status: UserLoanStatus): Boolean {
        return jpaRepository.existsByBookTitleAndStatus(bookTitle, status)
    }

    override fun findAllByStatus(status: UserLoanStatus): List<UserLoanHistory> {
        return jpaRepository.findAllByStatus(status)
    }
}