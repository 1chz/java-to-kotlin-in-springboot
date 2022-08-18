package io.github.shirohoo.library.application.service.book

import io.github.shirohoo.library.domain.book.Book
import io.github.shirohoo.library.domain.book.BookRepository
import io.github.shirohoo.library.domain.book.BookType
import io.github.shirohoo.library.domain.user.UserLoanHistoryRepository
import io.github.shirohoo.library.domain.user.UserLoanStatus
import io.github.shirohoo.library.domain.user.UserRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
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

        runBlocking {
            val user = async { userRepository.findBy(username) }
            val book = async { bookRepository.findBy(bookTitle) }

            user.await().loanBook(book.await())
        }
    }

    @Transactional
    fun returnBook(username: String, bookTitle: String) {
        val user = userRepository.findBy(username)
        user.returnBook(bookTitle)
    }

    @Transactional(readOnly = true)
    fun countLoanedBooks(): Int {
        return userLoanHistoryRepository.findAllByStatus(UserLoanStatus.LOANED)
            .count()
    }

    @Transactional(readOnly = true)
    fun getBookStatistics(): Map<BookType, List<Book>> {
        return bookRepository.findAll()
            .groupBy(Book::type)
    }
}
