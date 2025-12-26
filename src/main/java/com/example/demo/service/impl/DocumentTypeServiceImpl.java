package com.example.demo.service.impl;

import com.example.demo.model.DocumentType;
import com.example.demo.repository.DocumentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeServiceImpl {
    private final DocumentTypeRepository repo;
    public DocumentTypeServiceImpl(DocumentTypeRepository repo) { this.repo = repo; }
    public List<DocumentType> getRequiredTypes() { return repo.findByRequiredTrue(); }
}
