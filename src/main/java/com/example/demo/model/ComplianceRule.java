package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compliance_rules", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ruleName")
})
public class ComplianceRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String ruleDescription;
    private String matchType;
    private Double threshold;

    private LocalDateTime createdAt;

    public ComplianceRule() {}

    public ComplianceRule(String ruleName, String ruleDescription,
                          String matchType, Double threshold) {
        this.ruleName = ruleName;
        this.ruleDescription = ruleDescription;
        this.matchType = matchType;
        this.threshold = threshold;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.threshold == null) {
            this.threshold = 0.0;
        }
    }

    // getters and setters
}
