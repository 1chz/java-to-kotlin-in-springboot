package io.github.shirohoo.library.application.persistence.book

import io.github.shirohoo.library.domain.book.Book
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BookJpaRepository : JpaRepository<Book, Long> {
    fun findByTitle(bookTitle: String): Optional<Book>
}