package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "vendor_document_types",
            joinColumns = @JoinColumn(name = "vendor_id"),
            inverseJoinColumns = @JoinColumn(name = "document_type_id")
    )
    private Set<DocumentType> supportedDocumentTypes = new HashSet<>();

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

    // getters & setters
}
