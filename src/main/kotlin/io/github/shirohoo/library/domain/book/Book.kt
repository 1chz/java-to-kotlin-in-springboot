package io.github.shirohoo.library.domain.book

import javax.persistence.*

@Entity
class Book(
    val title: String,

    @Enumerated(EnumType.STRING)
    val type: BookType,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    init {
        require(title.isNotBlank()) {
            "'title' must not be null or empty."
        }
    }
}
