package io.github.shirohoo.library.domain.user.loanhistory;

import static jakarta.persistence.GenerationType.IDENTITY;
import io.github.shirohoo.library.domain.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String bookName;

    private boolean isReturn;

    public UserLoanHistory() {

    }

    public UserLoanHistory(User user, String bookName, boolean isReturn) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = isReturn;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void doReturn() {
        this.isReturn = true;
    }
}
