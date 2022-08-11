package io.github.shirohoo.library.domain.book;

import io.github.shirohoo.library.application.domain.book.Book;
import java.util.Optional;

public interface BookRepository {
    Book save(Book newBook);

    Optional<Book> findBy(String bookTitle);
}
