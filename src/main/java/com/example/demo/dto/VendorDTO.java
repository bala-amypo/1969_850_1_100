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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVendorName() { return vendorName; }
    public void setVendorName(String vendorName) { this.vendorName = vendorName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getIndustry() { return industry; }
    public void setIndustry(String industry) { this.industry = industry; }
}
