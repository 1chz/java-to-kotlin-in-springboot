package io.github.shirohoo.library.application.data.user

data class UserCreateRequest(
    val name: String,
    val age: Int? = null,
)
