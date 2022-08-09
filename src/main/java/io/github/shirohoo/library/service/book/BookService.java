package io.github.shirohoo.library.service.book;

import io.github.shirohoo.library.domain.book.Book;
import io.github.shirohoo.library.domain.book.BookRepository;
import io.github.shirohoo.library.domain.user.User;
import io.github.shirohoo.library.domain.user.UserRepository;
import io.github.shirohoo.library.domain.user.loanhistory.UserLoanHistoryRepository;
import io.github.shirohoo.library.dto.book.request.BookLoanRequest;
import io.github.shirohoo.library.dto.book.request.BookRequest;
import io.github.shirohoo.library.dto.book.request.BookReturnRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;

    public BookService(
            BookRepository bookRepository,
            UserRepository userRepository,
            UserLoanHistoryRepository userLoanHistoryRepository
    ) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
    }

    @Transactional
    public void saveBook(BookRequest request) {
        Book newBook = new Book(request.getName());
        bookRepository.save(newBook);
    }

    @Transactional
    public void loanBook(BookLoanRequest request) {
        String userName = request.getUserName();
        String bookName = request.getBookName();

        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(bookName, false)) {
            throw new IllegalArgumentException("this book has already been borrowed.");
        }

        User user = userRepository.findByName(userName).orElseThrow();
        Book book = bookRepository.findByName(bookName).orElseThrow();
        user.loanBook(book);
    }

    @Transactional
    public void returnBook(BookReturnRequest request) {
        String userName = request.getUserName();
        User user = userRepository.findByName(userName).orElseThrow();
        user.returnBook(request.getBookName());
    }
}
