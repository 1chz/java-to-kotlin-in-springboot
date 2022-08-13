package io.github.shirohoo.library.application.data.user

import io.github.shirohoo.library.application.data.user.BookHistoryResponse.Companion.bookHistoryResponse
import io.github.shirohoo.library.domain.user.User
import io.github.shirohoo.library.domain.user.UserLoanHistory

data class UserLoanHistoryResponse(
    val name: String,
    val books: List<BookHistoryResponse>
) {
    companion object {
        fun userLoanHistoryResponse(user: User) = UserLoanHistoryResponse(
            name = user.name,
            books = user.userLoanHistories.map(::bookHistoryResponse)
        )
    }
}

data class BookHistoryResponse(
    val name: String,
    val isReturn: Boolean,
) {
    companion object {
        fun bookHistoryResponse(history: UserLoanHistory) = BookHistoryResponse(
            name = history.bookTitle,
            isReturn = history.isReturn
        )
    }
}
