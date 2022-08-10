package io.github.shirohoo.library.persistance.book;

import io.github.shirohoo.library.domain.book.Book;
import io.github.shirohoo.library.domain.book.BookRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final BookJpaRepository jpaRepository;

    public BookRepositoryImpl(BookJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Book save(Book newBook) {
        if (newBook == null) {
            return null;
        }
        return jpaRepository.save(newBook);
    }

    @Override
    public Optional<Book> findBy(String bookTitle) {
        return jpaRepository.findByTitle(bookTitle);
    }
}
