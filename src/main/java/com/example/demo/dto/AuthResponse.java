package com.example.demo.dto;

public class AuthResponse {

    private String message;
    private Long userId;
    private String email;
    private String role;

    public AuthResponse() {}

    // Constructor for single message
    public AuthResponse(String message) {
        this.message = message;
    }

    // Full constructor
    public AuthResponse(String message, Long userId, String email, String role) {
        this.message = message;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
