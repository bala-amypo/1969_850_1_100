package com.example.demo.util;

import com.example.demo.model.DocumentType;
import com.example.demo.model.VendorDocument;

import java.util.List;

public class ComplianceScoringEngine {

    /**
     * Calculates compliance score as percentage of uploaded & valid documents vs required types.
     */
    public double calculateScore(List<DocumentType> required, List<?> uploaded) {
        if (required.isEmpty()) return 100.0; // edge case: no required types

        double totalWeight = required.stream().mapToDouble(DocumentType::getWeight).sum();
        double obtained = 0.0;

        for (DocumentType dt : required) {
            for (Object obj : uploaded) {
                if (obj instanceof DocumentType && dt.getId().equals(((DocumentType) obj).getId())) {
                    obtained += dt.getWeight();
                } else if (obj instanceof VendorDocument) {
                    VendorDocument vd = (VendorDocument) obj;
                    if (vd.getDocumentType() != null && vd.getDocumentType().getId().equals(dt.getId()) && Boolean.TRUE.equals(vd.getIsValid())) {
                        obtained += dt.getWeight();
                    }
                }
            }
        }

        return (obtained / totalWeight) * 100.0;
    }

    /**
     * Returns rating based on score boundaries.
     */
    public String deriveRating(double score) {
        if (score >= 90) return "EXCELLENT";
        if (score >= 75) return "GOOD";
        if (score >= 50) return "POOR";
        return "NON_COMPLIANT";
    }
}

