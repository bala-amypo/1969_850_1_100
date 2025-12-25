package com.example.demo.service;

import com.example.demo.model.ComplianceRule;
import java.util.List;

public interface ComplianceRuleService {
    
    ComplianceRule createRule(ComplianceRule rule);
    List<ComplianceRule> getAllRules();
    ComplianceRule getRule(Long id);
}






package com.example.demo.service;

import com.example.demo.model.ComplianceScore;
import java.util.List;

public interface ComplianceScoreService {
    ComplianceScore evaluateVendor(Long vendorId);
    ComplianceScore getScore(Long vendorId);
    List<ComplianceScore> getAllScores();
}