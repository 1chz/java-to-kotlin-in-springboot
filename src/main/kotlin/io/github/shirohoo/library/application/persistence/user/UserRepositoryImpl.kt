package io.github.shirohoo.library.application.persistence.user

import io.github.shirohoo.library.domain.user.User
import io.github.shirohoo.library.domain.user.UserRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepositoryImpl(
    private val jpaRepository: UserJpaRepository
) : UserRepository {
    override fun save(newUser: User): User {
        return jpaRepository.save(newUser)
    }

    override fun findAll(): List<User> {
        return jpaRepository.findAll()
    }

    override fun findBy(id: Long): Optional<User> {
        return jpaRepository.findById(id)
    }

    override fun findBy(username: String): Optional<User> {
        return jpaRepository.findByName(username)
    }

    override fun delete(user: User) {
        jpaRepository.delete(user)
    }
}