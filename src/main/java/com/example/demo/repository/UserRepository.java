package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Used in AuthController & UserServiceImpl
    Optional<User> findByEmail(String email);

    // Used in tests to check duplicate users
    boolean existsByEmail(String email);
}

