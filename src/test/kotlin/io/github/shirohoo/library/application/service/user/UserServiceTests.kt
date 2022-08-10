package io.github.shirohoo.library.application.service.user

import io.github.shirohoo.library.application.persistance.book.BookJpaRepository
import io.github.shirohoo.library.application.persistance.user.UserJpaRepository
import io.github.shirohoo.library.domain.user.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTests @Autowired constructor(
    private var sut: UserService,
    private var userJpaRepository: UserJpaRepository,
    private var bookJpaRepository: BookJpaRepository
) {
    @Test
    fun `새로운 유저를 등록한다`() {
        val newUser = User("username", null)
        assertDoesNotThrow { sut.saveUser(newUser) }
    }

    @Test
    fun `등록된 모든 유저를 조회할 수 있다`() {
        // given
        sut.saveUser(User("user1", null))
        sut.saveUser(User("user2", 20))

        // when
        val users = sut.users

        // then
        assertThat(users).extracting("name").containsExactlyInAnyOrder("user1", "user2")
        assertThat(users).extracting("age").containsExactlyInAnyOrder(null, 20)
    }

    @Test
    fun `등록된 유저의 이름을 변경할 수 있다`() {
        // given
        val savedUser = userJpaRepository.save(User("username", null))

        // when and then
        assertDoesNotThrow { sut.updateUserName(savedUser.id, "modified name") }
    }

    @Test
    fun `등록된 유저를 삭제할 수 있다`() {
        // given
        sut.saveUser(User("username", null))

        // when and then
        assertDoesNotThrow { sut.deleteUser("username") }
    }

    @AfterEach
    fun tearDown() {
        userJpaRepository.deleteAll()
        bookJpaRepository.deleteAll()
    }
}