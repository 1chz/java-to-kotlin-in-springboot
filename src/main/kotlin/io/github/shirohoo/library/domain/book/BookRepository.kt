package io.github.shirohoo.library.domain.book

import java.util.*

interface BookRepository {
    fun save(newBook: Book): Book
    fun findBy(bookTitle: String): Optional<Book>
}