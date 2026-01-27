package com.example.demo.services.impl;

import com.example.demo.enums.UserStatus;
import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.mappers.UserMapper;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.toModels(userRepository.findAll());
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toModel)
                .orElseThrow(() -> new UserNotFoundException("User by ID [%s] not found".formatted(id)));
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.toModel(userRepository.findByUsername(username));
    }

    @Override
    public User register(User newUser) {

        if (existsByUsername(newUser.getUsername())) {
            throw new UserAlreadyExistsException("User by username [%s] already exists".formatted(newUser.getUsername()));
        }

        User user = User.builder()
                .id(newUser.getId())
                .lastname(newUser.getLastname())
                .firstname(newUser.getFirstname())
                .username(newUser.getUsername())
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .userStatus(newUser.getUserStatus())
                .build();

        return userMapper.toModel(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public User updateUser(Long userId, User updateUser) {
        User user = getById(userId);

        user.setId(updateUser.getId());
        user.setLastname(updateUser.getLastname());
        user.setFirstname(updateUser.getFirstname());
        user.setUsername(updateUser.getUsername());
        user.setEmail(updateUser.getEmail());
        user.setPassword(updateUser.getPassword());
        user.setUserStatus(updateUser.getUserStatus());

        return userMapper.toModel(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public void changeUserStatus(Long userId, UserStatus newStatus) {
        User user = getById(userId);
        user.setUserStatus(newStatus);

        userRepository.save(userMapper.toEntity(user));
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}
