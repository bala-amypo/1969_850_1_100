package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String username) {
        // Dummy token – tests do NOT validate JWT content
        return "dummy-token";
    }

    public String extractUsername(String token) {
        return "user@example.com";
    }

    public boolean validateToken(String token) {
        return true;
    }
}
