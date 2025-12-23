package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_scores")
public class ComplianceScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    private Vendor vendor;
    @Min(0)
    @Max(100)
    private Double scoreValue;

    private String rating;

    private LocalDateTime lastEvaluated;

    public ComplianceScore() {}

    // getters and setters
    public Long getId() { return id; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor)
     {
         this.vendor = vendor;
          }

    public Double getScoreValue()
     { 
        return scoreValue;
         }
    public void setScoreValue(Double scoreValue)
     { 
        this.scoreValue = scoreValue;
         }

    public String getRating() 
    { 
        return rating;
         }
    public void setRating(String rating) 
    {
         this.rating = rating;
          }

    public LocalDateTime getLastEvaluated() 
    { 
        return lastEvaluated; 
        }
    public void setLastEvaluated(LocalDateTime lastEvaluated)
     {
        this.lastEvaluated = lastEvaluated;
    }
}