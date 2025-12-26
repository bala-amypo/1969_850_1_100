package com.example.demo.util;

import java.util.List;

import com.example.demo.model.*;

public class ComplianceScoringEngine {

    // Example scoring logic (matches TestCaseHelper)
    public static double calculateScore(Vendor vendor,
                                        VendorDocumentRepository vendorDocumentRepository,
                                        ComplianceRuleRepository complianceRuleRepository) {

        // If no documents, return 0
        List<VendorDocument> documents = vendorDocumentRepository.findByVendor(vendor);
        if (documents.isEmpty()) return 0.0;

        // Basic weighted score calculation
        double totalWeight = 0;
        double scoreSum = 0;

        for (VendorDocument doc : documents) {
            if (doc.getIsValid() != null && doc.getIsValid()) {
                scoreSum += 1.0; // simple scoring, can be weighted by DocumentType.weight if needed
            }
            totalWeight += 1.0;
        }

        double result = (totalWeight == 0 ? 0 : (scoreSum / totalWeight) * 100);
        return Math.max(0, Math.min(result, 100)); // keep between 0–100
    }

    public static String deriveRating(double score) {
        if (score >= 90) return "EXCELLENT";
        if (score >= 70) return "GOOD";
        if (score >= 50) return "POOR";
        return "NONCOMPLIANT";
    }
}
