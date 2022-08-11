package io.github.shirohoo.library.domain.user;

import io.github.shirohoo.library.application.domain.user.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User newUser);

    List<User> findAll();

    Optional<User> findBy(long id);

    Optional<User> findBy(String username);

    boolean delete(User user);
}
