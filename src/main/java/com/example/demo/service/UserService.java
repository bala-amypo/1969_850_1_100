package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User register(User user);

    // Add authenticate method
    User authenticate(String email, String password);
}
