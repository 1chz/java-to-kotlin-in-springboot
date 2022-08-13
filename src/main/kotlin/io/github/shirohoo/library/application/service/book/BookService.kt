package io.github.shirohoo.library.application.service.book

import io.github.shirohoo.library.domain.book.Book
import io.github.shirohoo.library.domain.book.BookRepository
import io.github.shirohoo.library.domain.book.BookType
import io.github.shirohoo.library.domain.user.UserLoanHistoryRepository
import io.github.shirohoo.library.domain.user.UserLoanStatus
import io.github.shirohoo.library.domain.user.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository,
) {
    @Transactional
    fun saveBook(newBook: Book) = bookRepository.save(newBook)

    @Transactional
    fun loanBook(username: String, bookTitle: String) {
        if (userLoanHistoryRepository.existsBy(bookTitle, UserLoanStatus.LOANED)) {
            throw IllegalArgumentException("this book has already been borrowed.")
        }

        val user = userRepository.findBy(username)
        val book = bookRepository.findBy(bookTitle)

        user.loanBook(book)
    }

    @Transactional
    fun returnBook(username: String, bookTitle: String) {
        val user = userRepository.findBy(username)
        user.returnBook(bookTitle)
    }

    @Transactional(readOnly = true)
    fun countLoanedBooks(): Int =
        userLoanHistoryRepository.findAllByStatus(UserLoanStatus.LOANED)
            .count()

    @Transactional(readOnly = true)
    fun getBookStatistics(): Map<BookType, List<Book>> =
        bookRepository.findAll()
            .groupBy(Book::type)
}