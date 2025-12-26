package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ComplianceRule;

public interface ComplianceRuleRepository extends JpaRepository<ComplianceRule, Long> {
}
