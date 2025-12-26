package com.example.demo.dto;

public class ComplianceScoreDTO {
    private Long id;
    private Long vendorId;
    private Double scoreValue;
    private String rating;

    public ComplianceScoreDTO() {}

    public ComplianceScoreDTO(Long id, Long vendorId, Double scoreValue, String rating) {
        this.id = id;
        this.vendorId = vendorId;
        this.scoreValue = scoreValue;
        this.rating = rating;
    }

    // getters & setters
}
