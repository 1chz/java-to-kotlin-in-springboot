package io.github.shirohoo.library.application.persistence.user

import io.github.shirohoo.library.domain.user.User
import io.github.shirohoo.library.domain.user.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val jpaRepository: UserJpaRepository
) : UserRepository {
    override fun save(newUser: User): User = jpaRepository.save(newUser)

    override fun findAll(): List<User> = jpaRepository.findAll()

    override fun findAllWithHistories(): List<User> = jpaRepository.findAllWithHistories()

    override fun findBy(id: Long): User = jpaRepository.findByIdOrNull(id)
        ?: throw NoSuchElementException("user not found.")

    override fun findBy(username: String): User = jpaRepository.findByName(username)
        ?: throw NoSuchElementException("user not found.")


    override fun delete(user: User) = jpaRepository.delete(user)
}