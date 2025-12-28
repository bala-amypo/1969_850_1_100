package com.example.demo.service.impl;

import com.example.demo.model.ComplianceRule;
import com.example.demo.repository.ComplianceRuleRepository;
import com.example.demo.service.ComplianceRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // ✅ REQUIRED
public class ComplianceRuleServiceImpl implements ComplianceRuleService {

    private final ComplianceRuleRepository repo;

    public ComplianceRuleServiceImpl(ComplianceRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public ComplianceRule createRule(ComplianceRule rule) {
        return repo.save(rule);
    }

    @Override
    public List<ComplianceRule> getAllRules() {
        return repo.findAll();
    }

    @Override
    public ComplianceRule getRule(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rule not found"));
    }
}