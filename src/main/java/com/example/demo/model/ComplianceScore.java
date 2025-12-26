package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="compliance_scores")
public class ComplianceScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double scoreValue;
    private String rating;

    @ManyToOne
    private Vendor vendor;

    // Getters & Setters
    public double getScoreValue() { return scoreValue; }
    public void setScoreValue(double scoreValue) { this.scoreValue = scoreValue; }
    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }
    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }
}
