[9:05 AM, 12/20/2025] Sahana: package com.example.demo.repository;

import com.example.demo.model.ComplianceRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplianceRuleRepository extends JpaRepository<ComplianceRule, Long> {
}
[9:05 AM, 12/20/2025] Sahana: package com.example.demo.repository;

import com.example.demo.model.ComplianceScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComplianceScoreRepository extends JpaRepository<ComplianceScore, Long> {

    Optional<ComplianceScore> findByVendor_Id(Long vendorId);
}