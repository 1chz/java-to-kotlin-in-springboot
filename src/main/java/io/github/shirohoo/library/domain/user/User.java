package io.github.shirohoo.library.domain.user;

import static jakarta.persistence.GenerationType.IDENTITY;
import io.github.shirohoo.library.domain.book.Book;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users") // user is keyword in h2
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    public User() {
    }

    public User(String name, Integer age) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("'name' must not be null or empty.");
        }
        this.name = name;
        this.age = age;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void loanBook(Book book) {
        String bookName = book.getTitle();
        UserLoanHistory userLoanHistory = new UserLoanHistory(this, bookName, false);
        this.userLoanHistories.add(userLoanHistory);
    }

    public void returnBook(String bookName) {
        UserLoanHistory targetLoanHistory = this.userLoanHistories
                .stream()
                .filter(history -> history.getBookTitle().equals(bookName))
                .findFirst()
                .orElseThrow();

        targetLoanHistory.doReturn();
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public Long getId() {
        return this.id;
    }
}
