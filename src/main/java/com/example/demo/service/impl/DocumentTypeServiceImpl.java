package com.example.demo.service.impl;

import com.example.demo.model.DocumentType;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.service.DocumentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeRepository repo;

    public DocumentTypeServiceImpl(DocumentTypeRepository repo) {
        this.repo = repo;
    }

    // ✔ matches createDocumentType(DocumentType type)
    @Override
    public DocumentType createDocumentType(DocumentType type) {
        return repo.save(type);
    }

    // ✔ matches getAllDocumentTypes()
    @Override
    public List<DocumentType> getAllDocumentTypes() {
        return repo.findAll();
    }

    // ✔ matches getDocumentType(Long id)
    @Override
    public DocumentType getDocumentType(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("DocumentType not found"));
    }
}