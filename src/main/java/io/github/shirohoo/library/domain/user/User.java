package io.github.shirohoo.library.domain.user;

import static jakarta.persistence.GenerationType.IDENTITY;
import io.github.shirohoo.library.domain.book.Book;
import io.github.shirohoo.library.domain.user.loanhistory.UserLoanHistory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
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
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다");
        }
        this.name = name;
        this.age = age;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void loanBook(Book book) {
        this.userLoanHistories.add(new UserLoanHistory(this, book.getName(), false));
    }

    public void returnBook(String bookName) {
        UserLoanHistory targetHistory = this.userLoanHistories.stream()
                .filter(history -> history.getBookName().equals(bookName))
                .findFirst()
                .orElseThrow();
        targetHistory.doReturn();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }
}
