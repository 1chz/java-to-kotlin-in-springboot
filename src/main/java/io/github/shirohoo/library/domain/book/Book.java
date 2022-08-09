package io.github.shirohoo.library.domain.book;

import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Book() {

    }

    public Book(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
