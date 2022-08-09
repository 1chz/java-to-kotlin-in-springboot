package io.github.shirohoo.library.controller.user;

import io.github.shirohoo.library.dto.user.request.UserCreateRequest;
import io.github.shirohoo.library.dto.user.request.UserUpdateRequest;
import io.github.shirohoo.library.dto.user.response.UserResponse;
import io.github.shirohoo.library.service.user.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @PutMapping
    public void updateUserName(@RequestBody UserUpdateRequest request) {
        userService.updateUserName(request);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }
}
