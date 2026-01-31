package com.example.demo.controllers;

import com.example.demo.enums.UserStatus;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.register(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user.getId(), user);
    }

    @PutMapping("/change/status/{userId}/{userStatus}")
    public void changeUserStatus(@PathVariable Long userId,
                                 @PathVariable UserStatus userStatus) {
        userService.changeUserStatus(userId, userStatus);
    }
}
