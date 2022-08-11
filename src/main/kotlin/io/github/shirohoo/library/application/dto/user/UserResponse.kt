package io.github.shirohoo.library.application.dto.user

data class UserResponse(
    val id: Long,
    val name: String,
    val age: Int? = null,
)
