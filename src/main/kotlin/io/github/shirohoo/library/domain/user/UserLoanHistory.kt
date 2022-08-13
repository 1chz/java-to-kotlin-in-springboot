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

    val isReturn: Boolean = this.status == UserLoanStatus.RETURNED

    fun doReturn() {
        this.status = UserLoanStatus.RETURNED
    }
}