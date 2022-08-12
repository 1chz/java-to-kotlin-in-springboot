package io.github.shirohoo.library.application.data.book

import io.github.shirohoo.library.domain.book.BookType

data class BookRequest(
    val name: String,
    val type: BookType,
)
