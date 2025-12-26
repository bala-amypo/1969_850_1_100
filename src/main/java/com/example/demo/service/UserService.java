package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User registerUser(User user);

    Optional<User> getById(Long id);

    List<User> getAllUsers();

    User updateUser(User user);

    void delete(Long id);

    Optional<User> findByEmail(String email);
}
