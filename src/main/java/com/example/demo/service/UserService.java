package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;

public interface UserService {

    User save(User user);

    User getById(Long id);

    List<User> getAll();

    void delete(Long id);
}
