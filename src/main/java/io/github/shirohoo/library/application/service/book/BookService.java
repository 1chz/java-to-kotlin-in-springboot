package io.github.shirohoo.library.application.service.book;

import io.github.shirohoo.library.application.domain.book.Book;
import io.github.shirohoo.library.application.domain.user.User;
import io.github.shirohoo.library.domain.book.BookRepository;
import io.github.shirohoo.library.domain.user.UserLoanHistoryRepository;
import io.github.shirohoo.library.domain.user.UserRepository;
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
    public void saveBook(Book newBook) {
        if (bookRepository.save(newBook) == null) {
            throw new IllegalStateException("failed to save new book.");
        }
    }

    @Transactional
    public void loanBook(String username, String bookTitle) {
        if (userLoanHistoryRepository.existsBy(bookTitle, false)) {
            throw new IllegalArgumentException("this book has already been borrowed.");
        }

        User user = userRepository.findBy(username).orElseThrow();
        Book book = bookRepository.findBy(bookTitle).orElseThrow();

        user.loanBook(book);
    }

    @Transactional
    public void returnBook(String username, String bookTitle) {
        User user = userRepository.findBy(username).orElseThrow();
        user.returnBook(bookTitle);
    }
}
