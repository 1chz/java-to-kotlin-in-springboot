package io.github.shirohoo.library.application.controller.book;

import io.github.shirohoo.library.application.domain.book.Book;
import io.github.shirohoo.library.application.dto.book.BookLoanRequest;
import io.github.shirohoo.library.application.dto.book.BookRequest;
import io.github.shirohoo.library.application.dto.book.BookReturnRequest;
import io.github.shirohoo.library.application.service.book.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void saveBook(@RequestBody BookRequest request) {
        Book newBook = new Book(null, request.getName());
        bookService.saveBook(newBook);
    }

    @PostMapping("/loan")
    public void loanBook(@RequestBody BookLoanRequest request) {
        String username = request.getUserName();
        String bookTitle = request.getBookName();
        bookService.loanBook(username, bookTitle);
    }

    @PutMapping("/return")
    public void returnBook(@RequestBody BookReturnRequest request) {
        String username = request.getUserName();
        String bookTitle = request.getBookName();
        bookService.returnBook(username, bookTitle);
    }
}
