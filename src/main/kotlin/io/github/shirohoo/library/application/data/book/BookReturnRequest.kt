package io.github.shirohoo.library.application.data.book

import com.fasterxml.jackson.annotation.JsonProperty

data class BookReturnRequest(
    @field:JsonProperty("userName")
    val username: String,

    @field:JsonProperty("bookName")
    val bookTitle: String,
)
