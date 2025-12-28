package com.example.demo.dto;

public class VendorDTO {

    private Long id;
    private String vendorName;
    private String industry;

    public VendorDTO() {
    }

    public VendorDTO(Long id, String vendorName, String industry) {
        this.id = id;
        this.vendorName = vendorName;
        this.industry = industry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
