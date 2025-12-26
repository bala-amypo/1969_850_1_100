package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ComplianceRule;

public interface ComplianceRuleService {
    ComplianceRule createRule(ComplianceRule rule);
    List<ComplianceRule> getAllRules();
    ComplianceRule getRule(Long id);
}
