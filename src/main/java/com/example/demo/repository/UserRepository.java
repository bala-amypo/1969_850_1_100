package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // for login / security
    Optional<User> findByEmail(String email);

    // for authentication
    Optional<User> findByEmailAndPassword(String email, String password);
}
