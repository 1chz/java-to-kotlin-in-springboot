package io.github.shirohoo.library.application.domain.user

import io.github.shirohoo.library.application.domain.book.Book
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
    name: String,

    val age: Int? = null,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val userLoanHistories: MutableList<UserLoanHistory> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    var name = name
        private set

    init {
        require(name.isNotBlank()) {
            "'name' must not be null or empty."
        }
    }

    fun updateName(username: String) {
        this.name = username
    }

    fun loanBook(book: Book) {
        val bookTitle = book.title
        val userLoanHistory = UserLoanHistory(this, bookTitle, false)
        this.userLoanHistories.add(userLoanHistory)
    }

    fun returnBook(bookTitle: String) {
        this.userLoanHistories
            .first { it.bookTitle == bookTitle }
            .doReturn()
    }
}