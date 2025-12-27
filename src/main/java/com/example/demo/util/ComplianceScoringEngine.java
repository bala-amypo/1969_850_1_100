package com.example.demo.util;

import com.example.demo.model.DocumentType;
import com.example.demo.model.VendorDocument;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComplianceScoringEngine {

    /**
     * Calculates compliance score as percentage of valid uploaded documents
     * vs required document types.
     */
    public double calculateScore(List<DocumentType> required, List<?> uploaded) {

        if (required == null || required.isEmpty()) {
            return 100.0; // No required documents → fully compliant
        }

        double totalWeight = required.stream()
                .mapToDouble(DocumentType::getWeight)
                .sum();

        double obtained = 0.0;

        // Track already counted document types (prevents double counting)
        Set<Long> satisfiedDocs = new HashSet<>();

        for (DocumentType dt : required) {

            for (Object obj : uploaded) {

                if (obj instanceof VendorDocument vd) {

                    if (vd.getDocumentType() != null
                            && vd.getDocumentType().getId().equals(dt.getId())
                            && Boolean.TRUE.equals(vd.getIsValid())
                            && !satisfiedDocs.contains(dt.getId())) {

                        obtained += dt.getWeight();
                        satisfiedDocs.add(dt.getId());
                        break; // move to next required document
                    }
                }
            }
        }

        if (totalWeight == 0) return 0.0;

        double score = (obtained / totalWeight) * 100.0;

        // Safety clamp
        return Math.min(score, 100.0);
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
