package com.example.demo.util;

import java.util.List;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.ComplianceRuleRepository;

public class ComplianceScoringEngine {

    public static double calculateScore(Vendor vendor,
                                        VendorDocumentRepository vendorDocumentRepository,
                                        ComplianceRuleRepository complianceRuleRepository) {

        List<VendorDocument> documents = vendorDocumentRepository.findByVendor(vendor);
        if (documents.isEmpty()) return 0.0;

        double totalWeight = 0;
        double scoreSum = 0;

        for (VendorDocument doc : documents) {
            if (doc.getIsValid() != null && doc.getIsValid()) {
                scoreSum += 1.0;
            }
            totalWeight += 1.0;
        }

        double result = (totalWeight == 0 ? 0 : (scoreSum / totalWeight) * 100);
        return Math.max(0, Math.min(result, 100));
    }

    public static String deriveRating(double score) {
        if (score >= 90) return "EXCELLENT";
        if (score >= 70) return "GOOD";
        if (score >= 50) return "POOR";
        return "NONCOMPLIANT";
    }
}
