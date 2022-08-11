package io.github.shirohoo.library.application.persistance.user;

import io.github.shirohoo.library.application.domain.user.User;
import io.github.shirohoo.library.domain.user.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository jpaRepository;

    public UserRepositoryImpl(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public User save(User newUser) {
        if (newUser == null) {
            return null;
        }
        return jpaRepository.save(newUser);
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<User> findBy(long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Optional<User> findBy(String username) {
        return jpaRepository.findByName(username);
    }

    @Override
    public boolean delete(User user) {
        if (user == null) {
            return false;
        }
        jpaRepository.delete(user);
        return true;
    }
}
