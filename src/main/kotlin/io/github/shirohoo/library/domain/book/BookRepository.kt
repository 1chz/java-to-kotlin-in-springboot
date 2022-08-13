package io.github.shirohoo.library.domain.book

interface BookRepository {
    fun save(newBook: Book): Book
    fun findAll(): List<Book>
    fun findBy(bookTitle: String): Book
}