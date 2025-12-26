package com.example.demo.dto;

import java.time.LocalDate;

public class VendorDocumentDTO {
    private Long id;
    private Long vendorId;
    private Long documentTypeId;
    private String fileUrl;
    private LocalDate expiryDate;

    public VendorDocumentDTO() {}

    public VendorDocumentDTO(Long id, Long vendorId, Long documentTypeId, String fileUrl, LocalDate expiryDate) {
        this.id = id;
        this.vendorId = vendorId;
        this.documentTypeId = documentTypeId;
        this.fileUrl = fileUrl;
        this.expiryDate = expiryDate;
    }

    // getters & setters
}
