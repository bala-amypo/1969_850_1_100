package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DocumentType;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.service.DocumentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeRepository repository;

    public DocumentTypeServiceImpl(DocumentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public DocumentType create(DocumentType dt) {
        return repository.save(dt);
    }

    @Override
    public DocumentType getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DocumentType not found"));
    }

    @Override
    public List<DocumentType> getAll() {
        return repository.findAll();
    }
}