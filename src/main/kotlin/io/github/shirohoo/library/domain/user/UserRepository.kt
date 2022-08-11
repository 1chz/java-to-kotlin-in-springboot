package io.github.shirohoo.library.domain.user

import java.util.*

interface UserRepository {
    fun save(newUser: User): User
    fun findAll(): List<User>
    fun findBy(id: Long): Optional<User>
    fun findBy(username: String): Optional<User>
    fun delete(user: User)
}