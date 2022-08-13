package io.github.shirohoo.library.application.controller.user

import io.github.shirohoo.library.application.data.user.*
import io.github.shirohoo.library.application.service.user.UserService
import io.github.shirohoo.library.domain.user.User
import io.github.shirohoo.library.domain.user.UserLoanHistory
import io.github.shirohoo.library.domain.user.UserLoanStatus
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

    @GetMapping("/loan")
    fun getUserLoanHistories(): List<UserLoanHistoryResponse> {
        return userService.getUsers()
            .map(::userLoanHistoryResponse)
    }

    private fun userLoanHistoryResponse(user: User) = UserLoanHistoryResponse(
        name = user.name,
        books = user.userLoanHistories.map(::bookHistoryResponse)
    )

    private fun bookHistoryResponse(history: UserLoanHistory) = BookHistoryResponse(
        name = history.bookTitle,
        isReturn = history.status == UserLoanStatus.RETURNED
    )
}