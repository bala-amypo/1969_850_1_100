package com.example.demo.controller;

import com.example.demo.model.ComplianceRule;
import com.example.demo.service.ComplianceRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class ComplianceRuleController {

    private final ComplianceRuleService complianceRuleService;

    public ComplianceRuleController(ComplianceRuleService complianceRuleService) {
        this.complianceRuleService = complianceRuleService;
    }

    @PostMapping
    public ResponseEntity<ComplianceRule> create(@RequestBody ComplianceRule rule) {
        return ResponseEntity.ok(complianceRuleService.create(rule));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplianceRule> get(@PathVariable Long id) {
        return ResponseEntity.ok(complianceRuleService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ComplianceRule>> getAll() {
        return ResponseEntity.ok(complianceRuleService.getAll());
    }
}