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

    private String fileUrl;
    private LocalDate expiryDate;

    private Boolean isValid = true;
    private LocalDateTime uploadedAt;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "document_type_id")
    private DocumentType documentType;

    @PrePersist
    public void prePersist() {
        this.uploadedAt = LocalDateTime.now();
    }

    public Long getId() { 
        return id; 
        }
    public void setId(Long id) { 
    this.id = id;
     }

    public String getFileUrl() { 
        return fileUrl;
         }
    public void setFileUrl(String fileUrl) {
         this.fileUrl = fileUrl;
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
    public void setIsValid(Boolean valid) {
     isValid = valid;
      }
    public LocalDateTime getUploadedAt() {
         return uploadedAt;
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
}
