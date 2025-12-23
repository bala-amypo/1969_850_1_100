package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.ComplianceScore;
import com.example.demo.model.Vendor;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final VendorRepository vendorRepository;
    private final ComplianceScoreRepository complianceScoreRepository;

    public ComplianceScoreServiceImpl(VendorRepository vendorRepository,
                                      ComplianceScoreRepository complianceScoreRepository) {
        this.vendorRepository = vendorRepository;
        this.complianceScoreRepository = complianceScoreRepository;
    }

    @Override
    public ComplianceScore evaluateVendor(Long vendorId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        double scoreValue = 100;

        if (scoreValue < 0) {
            throw new ValidationException("Compliance score cannot be negative");
        }

        ComplianceScore score = complianceScoreRepository
                .findByVendor_Id(vendorId)
                .orElse(new ComplianceScore());

        score.setVendor(vendor);
        score.setScoreValue(scoreValue);
        score.setRating("GOOD");
        score.setLastEvaluated(LocalDateTime.now());

        return complianceScoreRepository.save(score);
    }
    @Override
    public ComplianceScore getScore(Long vendorId) {
        return complianceScoreRepository.findByVendor_Id(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Compliance score not found"));
    }

    @Override
    public List<ComplianceScore> getAllScores() {
        return complianceScoreRepository.findAll();
    }
}