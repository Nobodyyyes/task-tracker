package com.example.demo.services;

import com.example.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(Long id);


}
