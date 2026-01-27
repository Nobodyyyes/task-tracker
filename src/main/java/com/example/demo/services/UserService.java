package com.example.demo.services;

import com.example.demo.enums.UserStatus;
import com.example.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(Long id);

    User getByUsername(String username);

    User register(User newUser);

    User updateUser(Long userId, User updateUser);

    void changeUserStatus(Long userId, UserStatus newStatus);

    boolean existsByUsername(String username);
}
