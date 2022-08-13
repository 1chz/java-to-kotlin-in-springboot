package io.github.shirohoo.library.application.data.book

import io.github.shirohoo.library.domain.book.BookType

data class BookStatResponse(
    val type: BookType,
    val count: Int,
)
