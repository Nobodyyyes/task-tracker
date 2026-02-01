package com.example.demo.services;

import com.example.demo.models.User;

public interface AuthService {

    User login(String username, String password);
}
