package io.github.shirohoo.library.domain.book;

import java.util.Optional;

public interface BookRepository {
    Book save(Book newBook);

    Optional<Book> findBy(String bookTitle);
}
