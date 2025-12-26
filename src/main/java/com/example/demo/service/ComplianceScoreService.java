package com.example.demo.service;

import java.util.List;
import com.example.demo.model.ComplianceScore;

public interface ComplianceScoreService {
    ComplianceScore evaluateVendor(Long vendorId);
    ComplianceScore getScore(Long vendorId);
    List<ComplianceScore> getAllScores();
}
