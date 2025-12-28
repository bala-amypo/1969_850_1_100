package com.example.demo.dto;
public class ComplianceScoreDTO {
    private Long id;
    private Long vendorId;
    private double scoreValue;
    private String rating;
    public ComplianceScoreDTO() {
    }
    public ComplianceScoreDTO(Long id, Long vendorId, double scoreValue, String rating) {
        this.id = id;
        this.vendorId = vendorId;
        this.scoreValue = scoreValue;
        this.rating = rating;
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

    public double getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(double scoreValue) {
        this.scoreValue = scoreValue;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}

