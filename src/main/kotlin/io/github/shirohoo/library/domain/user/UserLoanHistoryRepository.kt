package io.github.shirohoo.library.domain.user

interface UserLoanHistoryRepository {
    fun existsBy(bookTitle: String, status: UserLoanStatus): Boolean
    fun findAllByStatus(status: UserLoanStatus): List<UserLoanHistory>
}
