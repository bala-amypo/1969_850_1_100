package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "compliance_scores")
public class ComplianceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TEST requires this field name EXACTLY "vendor"
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    private Double scoreValue;
    private String rating;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public Double getScoreValue() { return scoreValue; }
    public void setScoreValue(Double scoreValue) { this.scoreValue = scoreValue; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }
}
