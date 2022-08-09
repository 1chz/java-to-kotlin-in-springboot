package io.github.shirohoo.library.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {
    boolean existsByBookTitleAndIsReturn(String bookTitle, boolean isReturn);
}
