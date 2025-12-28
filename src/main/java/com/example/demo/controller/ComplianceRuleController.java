package com.example.demo.controller;

import com.example.demo.model.ComplianceRule;
import com.example.demo.service.ComplianceRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compliance-rules")
public class ComplianceRuleController {

    @Autowired
    private ComplianceRuleService service;

    @PostMapping
    public ComplianceRule createRule(@RequestBody ComplianceRule rule) {
        return service.createRule(rule);
    }

    @GetMapping
    public List<ComplianceRule> getAllRules() {
        return service.getAllRules();
    }

    @GetMapping("/{id}")
    public ComplianceRule getRule(@PathVariable Long id) {
        return service.getRule(id);
    }
}

