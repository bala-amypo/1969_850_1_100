package com.example.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_scores")
public class ComplianceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double scoreValue;
    private String rating;

    private LocalDateTime evaluatedAt;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @PrePersist
    public void prePersist() {
        this.evaluatedAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getScoreValue() { return scoreValue; }
    public void setScoreValue(double scoreValue) { this.scoreValue = scoreValue; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }

    public LocalDateTime getEvaluatedAt() { return evaluatedAt; }
}
