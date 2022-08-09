package io.github.shirohoo.library.controller.book;

import io.github.shirohoo.library.dto.book.request.BookLoanRequest;
import io.github.shirohoo.library.dto.book.request.BookRequest;
import io.github.shirohoo.library.dto.book.request.BookReturnRequest;
import io.github.shirohoo.library.service.book.BookService;
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
        bookService.saveBook(request);
    }

    @PostMapping("/loan")
    public void loanBook(@RequestBody BookLoanRequest request) {
        bookService.loanBook(request);
    }

    @PutMapping("/return")
    public void returnBook(@RequestBody BookReturnRequest request) {
        bookService.returnBook(request);
    }
}
