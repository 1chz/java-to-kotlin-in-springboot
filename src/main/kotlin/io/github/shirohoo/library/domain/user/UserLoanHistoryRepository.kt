package io.github.shirohoo.library.domain.user

interface UserLoanHistoryRepository {
    fun existsBy(bookTitle: String, isReturn: Boolean): Boolean
}