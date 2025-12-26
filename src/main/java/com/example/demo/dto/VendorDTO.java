package com.example.demo.dto;

public class VendorDTO {
    private Long id;
    private String vendorName;
    private String email;
    private String phone;
    private String industry;

    public VendorDTO() {}

    public VendorDTO(Long id, String vendorName, String email, String phone, String industry) {
        this.id = id;
        this.vendorName = vendorName;
        this.email = email;
        this.phone = phone;
        this.industry = industry;
    }

    // getters & setters
}
