package io.github.shirohoo.library.domain.user

import javax.persistence.*

@Entity
class UserLoanHistory(
    @ManyToOne
    val user: User,

    val bookTitle: String,

    isReturn: Boolean,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    var isReturn = isReturn
        private set

    fun doReturn() {
        this.isReturn = true
    }
}