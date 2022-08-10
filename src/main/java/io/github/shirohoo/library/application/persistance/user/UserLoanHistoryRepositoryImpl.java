package io.github.shirohoo.library.application.persistance.user;

import io.github.shirohoo.library.domain.user.UserLoanHistoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserLoanHistoryRepositoryImpl implements UserLoanHistoryRepository {
    private final UserLoanHistoryJpaRepository jpaRepository;

    public UserLoanHistoryRepositoryImpl(UserLoanHistoryJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public boolean existsBy(String bookTitle, boolean isReturn) {
        return jpaRepository.existsByBookTitleAndIsReturn(bookTitle, isReturn);
    }
}
