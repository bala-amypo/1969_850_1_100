package com.example.demo.dto;

public class ComplianceRuleDTO {
    private Long id;
    private String ruleName;
    private String ruleDescription;
    private String matchType;
    private Double threshold;

    public ComplianceRuleDTO() {}

    public ComplianceRuleDTO(Long id, String ruleName, String ruleDescription, String matchType, Double threshold) {
        this.id = id;
        this.ruleName = ruleName;
        this.ruleDescription = ruleDescription;
        this.matchType = matchType;
        this.threshold = threshold;
    }

    // getters & setters
}
