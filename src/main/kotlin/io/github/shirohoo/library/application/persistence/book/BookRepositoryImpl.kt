package io.github.shirohoo.library.application.persistence.book

import io.github.shirohoo.library.domain.book.Book
import io.github.shirohoo.library.domain.book.BookRepository
import org.springframework.stereotype.Repository

@Repository
class BookRepositoryImpl(
    private val jpaRepository: BookJpaRepository
) : BookRepository {
    override fun save(newBook: Book): Book {
        return jpaRepository.save(newBook)
    }

    override fun findBy(bookTitle: String): Book {
        return jpaRepository.findByTitle(bookTitle)
            .orElseThrow { NoSuchElementException("book not found.") }
    }
}