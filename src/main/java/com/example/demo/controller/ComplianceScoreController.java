package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.ComplianceScoreDTO;
import com.example.demo.model.ComplianceScore;
import com.example.demo.service.ComplianceScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compliance-scores")
public class ComplianceScoreController {

    private final ComplianceScoreService scoreService;

    @Autowired
    public ComplianceScoreController(ComplianceScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping("/evaluate")
    public ComplianceScoreDTO evaluate(@RequestParam Long vendorId) {
        ComplianceScore cs = scoreService.evaluateVendor(vendorId);
        return new ComplianceScoreDTO(cs.getId(),
                cs.getVendor().getId(),
                cs.getScoreValue(),
                cs.getRating());
    }

    @GetMapping("/vendor/{vendorId}")
    public ComplianceScoreDTO getScore(@PathVariable Long vendorId) {
        ComplianceScore cs = scoreService.getScore(vendorId);
        return new ComplianceScoreDTO(cs.getId(),
                cs.getVendor().getId(),
                cs.getScoreValue(),
                cs.getRating());
    }

    @GetMapping
    public List<ComplianceScoreDTO> getAll() {
        return scoreService.getAllScores().stream()
                .map(cs -> new ComplianceScoreDTO(cs.getId(),
                        cs.getVendor().getId(),
                        cs.getScoreValue(),
                        cs.getRating()))
                .collect(Collectors.toList());
    }
}
