package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_rules")
public class ComplianceRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Rule name is required")
    @Column(unique = true, nullable = false)
    private String ruleName;

    private String ruleDescription;

    @Column(nullable = false)
    private String matchType; // EXPIRYCHECK, DOCUMENTREQUIRED, WEIGHTEDSCORE

    @Min(value = 0, message = "Threshold cannot be negative")
    private Double threshold;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.threshold == null) {
            this.threshold = 0.0;
        }
    }

    public ComplianceRule() {}

    // getters and setters
    public Long getId() { return id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getRuleDescription() { return ruleDescription; }
    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }

    public Double getThreshold() { return threshold; }
    public void setThreshold(Double threshold) { this.threshold = threshold; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}