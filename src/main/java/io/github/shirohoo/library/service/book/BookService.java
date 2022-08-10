package io.github.shirohoo.library.service.book;

import io.github.shirohoo.library.domain.book.Book;
import io.github.shirohoo.library.domain.book.BookRepository;
import io.github.shirohoo.library.domain.user.User;
import io.github.shirohoo.library.domain.user.UserLoanHistoryRepository;
import io.github.shirohoo.library.domain.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userJpaRepository;
    private final UserLoanHistoryRepository userLoanHistoryJpaRepository;

    public BookService(
            BookRepository bookRepository,
            UserRepository userRepository,
            UserLoanHistoryRepository userLoanHistoryRepository
    ) {
        this.bookRepository = bookRepository;
        this.userJpaRepository = userRepository;
        this.userLoanHistoryJpaRepository = userLoanHistoryRepository;
    }

    @Transactional
    public void saveBook(Book newBook) {
        bookRepository.save(newBook);
    }

    @Transactional
    public void loanBook(String username, String bookTitle) {
        if (userLoanHistoryJpaRepository.existsByBookTitleAndIsReturn(bookTitle, false)) {
            throw new IllegalArgumentException("this book has already been borrowed.");
        }

        User user = userJpaRepository.findByName(username).orElseThrow();
        Book book = bookRepository.findByTitle(bookTitle).orElseThrow();

        user.loanBook(book);
    }

    @Transactional
    public void returnBook(String username, String bookTitle) {
        User user = userJpaRepository.findByName(username).orElseThrow();
        user.returnBook(bookTitle);
    }
}
