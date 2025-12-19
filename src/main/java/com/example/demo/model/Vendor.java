package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Vendor name is required")
    @Column(unique = true, nullable = false)
    private String vendorName;

    private String email;
    private String phone;
    private String industry;

    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
            name = "vendor_supported_documents",
            joinColumns = @JoinColumn(name = "vendor_id"),
            inverseJoinColumns = @JoinColumn(name = "document_type_id")
    )
    private Set<DocumentType> supportedDocumentTypes;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Vendor() {}

    // getters and setters
    public Long getId() { return id; }

    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }

    public Set<DocumentType> getSupportedDocumentTypes() { return supportedDocumentTypes; }
    public void setSupportedDocumentTypes(Set<DocumentType> supportedDocumentTypes) {
        this.supportedDocumentTypes = supportedDocumentTypes;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
//Vendor