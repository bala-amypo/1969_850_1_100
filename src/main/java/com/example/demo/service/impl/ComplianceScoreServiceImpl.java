package com.example.demo.service.impl;

import com.example.demo.model.ComplianceScore;
import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.ComplianceScoreRepository;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.ComplianceScoreService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow();

        Set<DocumentType> requiredTypes = vendor.getSupportedDocumentTypes();
        if (requiredTypes.isEmpty()) {
            return saveScore(vendor, 100.0);
        }

        List<VendorDocument> documents =
                vendorDocumentRepository.findByVendor(vendor);

        long validCount = requiredTypes.stream()
                .filter(dt ->
                        documents.stream().anyMatch(d ->
                                d.getDocumentType().equals(dt) &&
                                (d.getExpiryDate() == null ||
                                 d.getExpiryDate().isAfter(LocalDate.now()))
                        )
                )
                .count();

        double score = (validCount * 100.0) / requiredTypes.size();
        return saveScore(vendor, score);
    }

    @Override
    public ComplianceScore getScore(Long vendorId) {
        return complianceScoreRepository.findByVendor_Id(vendorId)
                .orElse(null);
    }

    private ComplianceScore saveScore(Vendor vendor, double scoreValue) {
        ComplianceScore score = new ComplianceScore();
        score.setVendor(vendor);
        score.setScoreValue(scoreValue);
        return complianceScoreRepository.save(score);
    }
}