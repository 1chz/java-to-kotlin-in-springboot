package io.github.shirohoo.library.application.data.user

import io.github.shirohoo.library.domain.user.User

data class UserResponse(
    val id: Long,
    val name: String,
    val age: Int? = null,
) {
    constructor(user: User) : this(user.id!!, user.name, user.age)
}
