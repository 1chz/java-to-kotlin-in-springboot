package io.github.shirohoo.library.application.persistence.user

import com.querydsl.jpa.impl.JPAQueryFactory
import io.github.shirohoo.library.domain.user.QUser.user
import io.github.shirohoo.library.domain.user.QUserLoanHistory.userLoanHistory
import io.github.shirohoo.library.domain.user.User

class UserQueryRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : UserQueryRepository {

    override fun findAllWithHistories(): List<User> =
        jpaQueryFactory.selectFrom(user)
            .distinct()
            .innerJoin(user.userLoanHistories, userLoanHistory).fetchJoin()
            .fetch()
}