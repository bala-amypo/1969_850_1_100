package com.example.demo.util;

import com.example.demo.model.DocumentType;
import com.example.demo.model.VendorDocument;
import java.util.List;

public class ComplianceScoringEngine {

    public double calculateScore(List<DocumentType> required, List<VendorDocument> submitted) {
        if (required.isEmpty()) return 100.0;
        int totalWeight = required.stream().mapToInt(DocumentType::getWeight).sum();
        int scoredWeight = submitted.stream()
                .filter(VendorDocument::getIsValid)
                .mapToInt(d -> d.getDocumentType().getWeight())
                .sum();
        return totalWeight == 0 ? 100.0 : (scoredWeight * 100.0 / totalWeight);
    }

    public String deriveRating(double score) {
        if (score >= 90) return "EXCELLENT";
        if (score >= 70) return "GOOD";
        if (score >= 50) return "POOR";
        return "NON_COMPLIANT";
    }
}
