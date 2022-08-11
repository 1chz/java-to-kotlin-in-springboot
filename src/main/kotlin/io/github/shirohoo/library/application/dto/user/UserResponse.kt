package io.github.shirohoo.library.application.dto.user

import io.github.shirohoo.library.domain.user.User

data class UserResponse(
    val id: Long,
    val name: String,
    val age: Int? = null,
) {
    constructor(user: User) : this(user.id!!, user.name, user.age)
}
