package io.github.shirohoo.library.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String bookTitle;

    private boolean isReturn;

    public UserLoanHistory() {
    }

    public UserLoanHistory(User user, String bookTitle, boolean isReturn) {
        this.user = user;
        this.bookTitle = bookTitle;
        this.isReturn = isReturn;
    }

    public String getBookTitle() {
        return this.bookTitle;
    }

    public void doReturn() {
        this.isReturn = true;
    }
}
