package io.github.shirohoo.library.application.persistence.user

import io.github.shirohoo.library.domain.user.User

interface UserQueryRepository {
    fun findAllWithHistories(): List<User>
}