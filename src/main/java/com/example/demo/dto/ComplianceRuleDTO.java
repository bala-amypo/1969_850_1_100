package com.example.demo.dto;

public class ComplianceRuleDTO {

    private Long id;
    private String ruleName;
    private String matchType;
    private double threshold;

    public ComplianceRuleDTO() {
    }

    public ComplianceRuleDTO(Long id, String ruleName, String matchType, double threshold) {
        this.id = id;
        this.ruleName = ruleName;
        this.matchType = matchType;
        this.threshold = threshold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
}