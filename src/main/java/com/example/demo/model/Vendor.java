package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendors", uniqueConstraints = {
        @UniqueConstraint(columnNames = "vendorName")
})
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vendorName;
    private String email;
    private String phone;
    private String industry;

    private LocalDateTime createdAt;

    public Vendor() {}

    public Vendor(String vendorName, String email, String phone, String industry) {
        this.vendorName = vendorName;
        this.email = email;
        this.phone = phone;
        this.industry = industry;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
}
