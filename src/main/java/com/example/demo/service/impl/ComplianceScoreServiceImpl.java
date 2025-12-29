package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ComplianceScore;
import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.ComplianceScoreService;
import com.example.demo.util.ComplianceScoringEngine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceScoreServiceImpl implements ComplianceScoreService {

    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;
    private final VendorDocumentRepository vendorDocumentRepository;
    private final ComplianceScoreRepository complianceScoreRepository;

    public ComplianceScoreServiceImpl(
            VendorRepository vendorRepository,
            DocumentTypeRepository documentTypeRepository,
            VendorDocumentRepository vendorDocumentRepository,
            ComplianceScoreRepository complianceScoreRepository
    ) {
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.complianceScoreRepository = complianceScoreRepository;
    }

    @Override
    public ComplianceScore evaluateVendor(Long vendorId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vendor not found"));

        List<DocumentType> requiredTypes =
                documentTypeRepository.findByRequiredTrue();

        // No required docs → 100%
        if (requiredTypes.isEmpty()) {
            ComplianceScore score = new ComplianceScore();
            score.setVendor(vendor);
            score.setScoreValue(100.0);
            score.setRating("EXCELLENT");
            return complianceScoreRepository.save(score);
        }

        List<VendorDocument> documents =
                vendorDocumentRepository.findByVendor(vendor);

        int totalWeight = requiredTypes.stream()
                .mapToInt(DocumentType::getWeight)
                .sum();

        int obtainedWeight = 0;

        for (DocumentType dt : requiredTypes) {
            boolean hasValid = documents.stream().anyMatch(d ->
                    d.getDocumentType().getId().equals(dt.getId()) &&
                    d.isValid()
            );

            if (hasValid) {
                obtainedWeight += dt.getWeight();
            }
        }

        double scoreValue = (obtainedWeight * 100.0) / totalWeight;

        ComplianceScore score = new ComplianceScore();
        score.setVendor(vendor);
        score.setScoreValue(scoreValue);
        score.setRating(
                new ComplianceScoringEngine().deriveRating(scoreValue)
        );

        return complianceScoreRepository.save(score);
    }

    @Override
    public ComplianceScore getScore(Long vendorId) {
        return complianceScoreRepository.findByVendor_Id(vendorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Score not found"));
    }
}
