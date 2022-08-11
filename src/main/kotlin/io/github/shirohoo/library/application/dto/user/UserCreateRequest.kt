package io.github.shirohoo.library.application.dto.user

data class UserCreateRequest(
    val name: String,
    val age: Int? = null,
)
