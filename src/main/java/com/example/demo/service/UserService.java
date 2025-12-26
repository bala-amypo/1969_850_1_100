package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    // Methods required by AuthController
    User registerUser(User user);
    Optional<User> findByEmail(String email);

    // Generic CRUD methods
    User save(User user);
    User getById(Long id);
    List<User> getAll();
    void delete(Long id);
}
