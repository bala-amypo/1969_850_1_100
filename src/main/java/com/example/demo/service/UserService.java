package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    // Register/save a new user
    User registerUser(User user);

    // Find user by email
    User findByEmail(String email);

    // Find user by ID
    User getById(Long id);

    // Get all users
    List<User> getAllUsers();

    // Delete user by ID
    void delete(Long id);
}
