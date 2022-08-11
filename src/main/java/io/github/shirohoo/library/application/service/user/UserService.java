package io.github.shirohoo.library.application.service.user;

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
        userRepository.save(newUser);
    }

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void updateUsername(long userId, String username) {
        User user = userRepository.findBy(userId).orElseThrow();
        user.updateName(username);
    }

    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findBy(name).orElseThrow();
        userRepository.delete(user);
    }
}
