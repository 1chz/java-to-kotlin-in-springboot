package io.github.shirohoo.library.domain.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    public Book() {
    }

    public Book(String title) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("'title' must not be null or empty.");
        }
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}
