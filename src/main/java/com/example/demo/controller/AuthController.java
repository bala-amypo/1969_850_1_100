package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // ================== REGISTER ==================
    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        // Make sure UserService has 'register' method
        User savedUser = userService.register(user);

        // Return a message
        return new AuthResponse("User registered with id: " + savedUser.getId());
    }

    // ================== LOGIN ==================
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        // Authenticate user via UserService
        User user = userService.authenticate(request.getEmail(), request.getPassword());

        // Return AuthResponse with full info
        return new AuthResponse("Login successful", user.getId(), user.getEmail(), user.getRole());
    }
}
