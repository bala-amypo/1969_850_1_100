package com.example.demo.dto;

import java.time.LocalDate;

public class VendorDocumentDTO {

    private Long id;
    private Long vendorId;
    private Long documentTypeId;
    private String fileUrl;
    private LocalDate expiryDate;
    private boolean isValid;

    public VendorDocumentDTO() {
    }

    public VendorDocumentDTO(Long id, Long vendorId, Long documentTypeId, String fileUrl,
                             LocalDate expiryDate, boolean isValid) {
        this.id = id;
        this.vendorId = vendorId;
        this.documentTypeId = documentTypeId;
        this.fileUrl = fileUrl;
        this.expiryDate = expiryDate;
        this.isValid = isValid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Long documentTypeId) {
        this.documentTypeId = documentTypeId;
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

    public boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
}