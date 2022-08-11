package io.github.shirohoo.library.application.persistence.user

import io.github.shirohoo.library.domain.user.UserLoanHistoryRepository
import org.springframework.stereotype.Repository

@Repository
class UserLoanHistoryRepositoryImpl(
    private val jpaRepository: UserLoanHistoryJpaRepository
) : UserLoanHistoryRepository {
    override fun existsBy(bookTitle: String, isReturn: Boolean): Boolean {
        return jpaRepository.existsByBookTitleAndIsReturn(bookTitle, isReturn)
    }
}