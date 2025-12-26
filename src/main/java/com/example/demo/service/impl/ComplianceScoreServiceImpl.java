package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.exception.ValidationException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ComplianceScore;
import com.example.demo.model.Vendor;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.repository.ComplianceRuleRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.ComplianceScoreService;
import com.example.demo.util.ComplianceScoringEngine;

import org.springframework.stereotype.Service;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final ComplianceScoreRepository complianceScoreRepository;
    private final VendorRepository vendorRepository;
    private final VendorDocumentRepository vendorDocumentRepository;
    private final ComplianceRuleRepository complianceRuleRepository;

    public ComplianceScoreServiceImpl(ComplianceScoreRepository complianceScoreRepository,
                                      VendorRepository vendorRepository,
                                      VendorDocumentRepository vendorDocumentRepository,
                                      ComplianceRuleRepository complianceRuleRepository) {
        this.complianceScoreRepository = complianceScoreRepository;
        this.vendorRepository = vendorRepository;
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.complianceRuleRepository = complianceRuleRepository;
    }

    @Override
    public ComplianceScore evaluateVendor(Long vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        double score = ComplianceScoringEngine.calculateScore(vendor, vendorDocumentRepository,
                complianceRuleRepository);

        if (score < 0) {
            throw new ValidationException("Compliance score cannot be negative");
        }

        ComplianceScore cs = complianceScoreRepository.findByVendorId(vendorId)
                .orElse(new ComplianceScore(vendor, score, ComplianceScoringEngine.deriveRating(score)));

        cs.setScoreValue(score);
        cs.setRating(ComplianceScoringEngine.deriveRating(score));

        return complianceScoreRepository.save(cs);
    }

    @Override
    public ComplianceScore getScore(Long vendorId) {
        return complianceScoreRepository.findByVendorId(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("ComplianceScore not found"));
    }

    @Override
    public List<ComplianceScore> getAllScores() {
        return complianceScoreRepository.findAll();
    }
}
