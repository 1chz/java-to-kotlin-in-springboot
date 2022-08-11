package io.github.shirohoo.library.application.service

import io.github.shirohoo.library.domain.user.User
import io.github.shirohoo.library.domain.user.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {
    @Transactional
    fun saveUser(newUser: User) = userRepository.save(newUser)

    @Transactional(readOnly = true)
    fun getUsers(): List<User> = userRepository.findAll()

    @Transactional
    fun updateUsername(userId: Long, username: String) {
        userRepository.findBy(userId).updateName(username)
    }

    @Transactional
    fun deleteUser(username: String) {
        val user = userRepository.findBy(username)
        userRepository.delete(user)
    }
}