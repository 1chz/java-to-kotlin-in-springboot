package io.github.shirohoo.library.application.persistance.user;

import io.github.shirohoo.library.application.domain.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
}
