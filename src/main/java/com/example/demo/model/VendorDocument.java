package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "vendor_documents")
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private DocumentType documentType;

    @Column(nullable = false)
    private String fileUrl;

    private LocalDateTime uploadedAt;
    private LocalDate expiryDate;
    private Boolean isValid;

    public VendorDocument() {}

    public VendorDocument(String fileUrl, LocalDate expiryDate) {
        this.fileUrl = fileUrl;
        this.expiryDate = expiryDate;
    }

    @PrePersist
    public void prePersist() {
        this.uploadedAt = LocalDateTime.now();

        if (expiryDate == null || expiryDate.isAfter(LocalDate.now())) {
            this.isValid = true;
        } else {
            this.isValid = false;
        }
    }

    // getters and setters
}
