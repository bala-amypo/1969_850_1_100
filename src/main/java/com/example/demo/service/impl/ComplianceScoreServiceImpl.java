package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.util.ComplianceScoringEngine;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplianceScoreServiceImpl {
    private final VendorRepository vendorRepo;
    private final DocumentTypeRepository typeRepo;
    private final VendorDocumentRepository docRepo;
    private final ComplianceScoreRepository scoreRepo;
    private final ComplianceScoringEngine scoringEngine = new ComplianceScoringEngine();

    public ComplianceScoreServiceImpl(VendorRepository vendorRepo, DocumentTypeRepository typeRepo, VendorDocumentRepository docRepo, ComplianceScoreRepository scoreRepo) {
        this.vendorRepo = vendorRepo;
        this.typeRepo = typeRepo;
        this.docRepo = docRepo;
        this.scoreRepo = scoreRepo;
    }

    public ComplianceScore evaluateVendor(Long vendorId) {
        Vendor vendor = vendorRepo.findById(vendorId).orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        List<DocumentType> required = typeRepo.findByRequiredTrue();
        List<VendorDocument> submitted = docRepo.findByVendor(vendor);

        double score = scoringEngine.calculateScore(required, submitted);

        ComplianceScore cs = scoreRepo.findByVendor_Id(vendorId).orElse(new ComplianceScore());
        cs.setVendor(vendor);
        cs.setScoreValue(score);
        cs.setRating(scoringEngine.deriveRating(score));
        return scoreRepo.save(cs);
    }

    public ComplianceScore getScore(Long vendorId) {
        return scoreRepo.findByVendor_Id(vendorId).orElseThrow(() -> new ResourceNotFoundException("Score not found"));
    }
}
