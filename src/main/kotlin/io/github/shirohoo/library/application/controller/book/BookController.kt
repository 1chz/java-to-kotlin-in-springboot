package io.github.shirohoo.library.application.controller.book

import io.github.shirohoo.library.application.dto.book.BookLoanRequest
import io.github.shirohoo.library.application.dto.book.BookRequest
import io.github.shirohoo.library.application.dto.book.BookReturnRequest
import io.github.shirohoo.library.application.service.book.BookService
import io.github.shirohoo.library.domain.book.Book
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(
    private val bookService: BookService
) {
    @PostMapping
    fun saveBook(@RequestBody request: BookRequest) {
        val newBook = Book(request.name)
        bookService.saveBook(newBook)
    }

    @PostMapping("/loan")
    fun loanBook(@RequestBody request: BookLoanRequest) {
        val (username, bookTitle) = request
        bookService.loanBook(username, bookTitle)
    }

    @PutMapping("/return")
    fun returnBook(@RequestBody request: BookReturnRequest) {
        val (username, bookTitle) = request
        bookService.returnBook(username, bookTitle)
    }
}