package io.github.shirohoo.library.service.user;

import io.github.shirohoo.library.domain.user.User;
import io.github.shirohoo.library.domain.user.UserRepository;
import io.github.shirohoo.library.dto.user.UserResponse;
import java.util.List;
import java.util.stream.Collectors;
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
    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateUserName(long userId, String username) {
        User user = userRepository.findById(userId).orElseThrow();
        user.updateName(username);
    }

    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findByName(name).orElseThrow();
        userRepository.delete(user);
    }
}
