package io.github.shirohoo.library.domain.user

import javax.persistence.*

@Entity
class UserLoanHistory(
    @ManyToOne
    val user: User,

    val bookTitle: String,

    status: UserLoanStatus,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    var status: UserLoanStatus = status
        private set

    fun doReturn() {
        this.status = UserLoanStatus.RETURNED
    }
}