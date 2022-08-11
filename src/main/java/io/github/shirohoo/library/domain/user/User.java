package io.github.shirohoo.library.domain.user;

import io.github.shirohoo.library.application.domain.book.Book;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users") // user is keyword in h2
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
