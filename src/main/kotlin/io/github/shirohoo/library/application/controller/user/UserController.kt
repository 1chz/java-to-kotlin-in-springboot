package io.github.shirohoo.library.application.controller.user

import io.github.shirohoo.library.application.dto.user.UserCreateRequest
import io.github.shirohoo.library.application.dto.user.UserResponse
import io.github.shirohoo.library.application.dto.user.UserUpdateRequest
import io.github.shirohoo.library.application.service.user.UserService
import io.github.shirohoo.library.domain.user.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {
    @GetMapping
    fun getUsers(): List<UserResponse> {
        return userService.getUsers()
            .map(::UserResponse)
    }

    @PostMapping
    fun saveUser(@RequestBody request: UserCreateRequest) {
        val user = request.let { User(it.name, it.age) }
        userService.saveUser(user)
    }

    @PutMapping
    fun updateUsername(@RequestBody request: UserUpdateRequest) {
        val (userId, username) = request
        userService.updateUsername(userId, username)
    }

    @DeleteMapping
    fun deleteUser(@RequestBody username: String) = userService.deleteUser(username)
}