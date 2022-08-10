package io.github.shirohoo.library.service.user;

import io.github.shirohoo.library.domain.user.User;
import io.github.shirohoo.library.domain.user.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(User newUser) {
        if (userRepository.save(newUser) == null) {
            throw new IllegalStateException("failed save to new user");
        }
    }

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void updateUserName(long userId, String username) {
        User user = userRepository.findBy(userId).orElseThrow();
        user.updateName(username);
    }

    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findBy(name).orElseThrow();
        if (!userRepository.delete(user)) {
            throw new IllegalStateException("failed delete to user");
        }
    }
}
