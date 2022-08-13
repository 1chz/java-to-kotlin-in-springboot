package io.github.shirohoo.library.domain.user

interface UserRepository {
    fun save(newUser: User): User
    fun findAll(): List<User>
    fun findAllWithHistories(): List<User>
    fun findBy(id: Long): User
    fun findBy(username: String): User
    fun delete(user: User)
}