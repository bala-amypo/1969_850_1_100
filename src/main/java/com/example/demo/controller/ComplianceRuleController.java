package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.ComplianceRuleDTO;
import com.example.demo.model.ComplianceRule;
import com.example.demo.service.ComplianceRuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compliance-rules")
public class ComplianceRuleController {

    private final ComplianceRuleService ruleService;

    @Autowired
    public ComplianceRuleController(ComplianceRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public ComplianceRuleDTO create(@RequestBody ComplianceRuleDTO dto) {
        ComplianceRule saved = ruleService.createRule(
                new ComplianceRule(dto.getRuleName(), dto.getRuleDescription(),
                        dto.getMatchType(), dto.getThreshold()));
        return new ComplianceRuleDTO(saved.getId(), saved.getRuleName(),
                saved.getRuleDescription(), saved.getMatchType(), saved.getThreshold());
    }

    @GetMapping
    public List<ComplianceRuleDTO> getAll() {
        return ruleService.getAllRules().stream()
                .map(r -> new ComplianceRuleDTO(r.getId(), r.getRuleName(),
                        r.getRuleDescription(), r.getMatchType(), r.getThreshold()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ComplianceRuleDTO get(@PathVariable Long id) {
        ComplianceRule r = ruleService.getRule(id);
        return new ComplianceRuleDTO(r.getId(), r.getRuleName(),
                r.getRuleDescription(), r.getMatchType(), r.getThreshold());
    }
}
