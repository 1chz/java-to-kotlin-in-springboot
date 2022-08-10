package io.github.shirohoo.library.application.persistance.book;

import io.github.shirohoo.library.domain.book.Book;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String bookTitle);
}
