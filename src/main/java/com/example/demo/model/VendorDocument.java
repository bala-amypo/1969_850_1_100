package com.example.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "vendor_documents")
public class VendorDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;
    @NotBlank(message = "File URL is required")
    @Column(nullable = false)
    
    private String fileUrl;

    private LocalDateTime uploadedAt;
    private LocalDate expiryDate;
    private Boolean isValid;
    public VendorDocument() {}

    @PrePersist
    public void onCreate() {
        this.uploadedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public Vendor getVendor() {
        return vendor;
    }
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }
    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getFileUrl() {
        return fileUrl;
    }
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }
    public void setUploadedAt(LocalDateTime uploadedAt){
    this.uploadedAt=uploadedAt=uploadedAt;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getIsValid() {
        return isValid;
    }
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
}