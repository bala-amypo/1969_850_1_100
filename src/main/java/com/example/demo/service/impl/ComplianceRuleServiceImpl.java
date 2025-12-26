package com.example.demo.service.impl;

import com.example.demo.model.ComplianceRule;
import com.example.demo.repository.ComplianceRuleRepository;
import org.springframework.stereotype.Service;

@Service
public class ComplianceRuleServiceImpl {
    private final ComplianceRuleRepository repo;
    public ComplianceRuleServiceImpl(ComplianceRuleRepository repo) { this.repo = repo; }
    public ComplianceRule save(ComplianceRule rule) { return repo.save(rule); }
}
