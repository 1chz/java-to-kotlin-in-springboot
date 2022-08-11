package io.github.shirohoo.library.application.domain.book

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val title: String
) {
    init {
        require(title.isNotBlank()) {
            "'title' must not be null or empty."
        }
    }
}
