package com.example.demo.mappers;

import com.example.demo.entities.UserEntity;
import com.example.demo.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements BaseMapper<User, UserEntity> {

    @Override
    public User toModel(UserEntity entity) {
        if (entity == null) return null;

        return User.builder()
                .id(entity.getId())
                .lastname(entity.getLastname())
                .firstname(entity.getFirstname())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .userStatus(entity.getUserStatus())
                .build();
    }

    @Override
    public UserEntity toEntity(User model) {
        if (model == null) return null;

        return UserEntity.builder()
                .id(model.getId())
                .lastname(model.getLastname())
                .firstname(model.getFirstname())
                .username(model.getUsername())
                .email(model.getEmail())
                .password(model.getPassword())
                .userStatus(model.getUserStatus())
                .build();
    }
}
