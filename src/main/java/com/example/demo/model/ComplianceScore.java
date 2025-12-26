package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_scores")
public class ComplianceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Vendor vendor;

    private Double scoreValue;
    private String rating;
    private LocalDateTime lastEvaluated;

    public ComplianceScore() {}

    public ComplianceScore(Vendor vendor, Double scoreValue, String rating) {
        this.vendor = vendor;
        this.scoreValue = scoreValue;
        this.rating = rating;
    }

    @PrePersist
    public void prePersist() {
        this.lastEvaluated = LocalDateTime.now();
    }

    // getters and setters
}
