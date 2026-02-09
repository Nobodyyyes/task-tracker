package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/login")
@RequiredArgsConstructor
public class LoginController {

    private final AuthService authService;

    @GetMapping("/username/{username}/password/{password}")
    public User login(@PathVariable String username,
                      @PathVariable String password) {
        return authService.login(username, password);
    }
}
