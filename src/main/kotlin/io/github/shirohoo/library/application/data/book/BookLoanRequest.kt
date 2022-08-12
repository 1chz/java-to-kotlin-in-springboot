package io.github.shirohoo.library.application.data.book

import com.fasterxml.jackson.annotation.JsonProperty

data class BookLoanRequest(
    @field:JsonProperty(value = "userName")
    val username: String,

    @field:JsonProperty(value = "bookName")
    val bookTitle: String,
)
