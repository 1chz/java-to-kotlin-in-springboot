package io.github.shirohoo.library.domain.user;

public interface UserLoanHistoryRepository {
    boolean existsBy(String bookTitle, boolean isReturn);
}
