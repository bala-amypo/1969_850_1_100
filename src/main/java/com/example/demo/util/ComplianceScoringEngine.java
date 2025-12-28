package com.example.demo.util;

import com.example.demo.model.DocumentType;
import java.util.List;

public class ComplianceScoringEngine {

    public double calculateScore(List<DocumentType> requiredTypes, List<DocumentType> submittedTypes) {
        if (requiredTypes == null || requiredTypes.isEmpty()) return 100.0;

        int totalWeight = 0;
        int achieved = 0;

        for (DocumentType dt : requiredTypes) {
            totalWeight += dt.getWeight();
            boolean present = submittedTypes != null && submittedTypes.stream()
                    .anyMatch(x -> x.getId() != null && x.getId().equals(dt.getId()));
            if (present) achieved += dt.getWeight();
        }

        if (totalWeight == 0) return 100.0;
        return (achieved * 100.0) / totalWeight;
    }

    public String deriveRating(double score) {
        if (score >= 90.0) return "EXCELLENT";
        if (score >= 75.0) return "GOOD";
        if (score >= 50.0) return "POOR";
        return "NON_COMPLIANT";
    }
}
