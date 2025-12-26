package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.DocumentType;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {

    boolean existsByTypeName(String typeName);

    List<DocumentType> findByRequiredTrue();
}
