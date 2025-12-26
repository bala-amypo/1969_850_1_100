package com.example.demo.service;

import com.example.demo.model.DocumentType;

import java.util.List;

public interface DocumentTypeService {
    DocumentType create(DocumentType dt);
    DocumentType getById(Long id);
    List<DocumentType> getAll();
}
