package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.DocumentTypeDTO;
import com.example.demo.model.DocumentType;
import com.example.demo.service.DocumentTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/document-types")
public class DocumentTypeController {

    private final DocumentTypeService documentTypeService;

    @Autowired
    public DocumentTypeController(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    @PostMapping
    public DocumentTypeDTO create(@RequestBody DocumentTypeDTO dto) {
        DocumentType dt = new DocumentType(dto.getTypeName(), dto.getDescription(),
                dto.getRequired(), dto.getWeight());
        DocumentType saved = documentTypeService.createDocumentType(dt);
        return new DocumentTypeDTO(saved.getId(), saved.getTypeName(),
                saved.getDescription(), saved.getRequired(), saved.getWeight());
    }

    @GetMapping
    public List<DocumentTypeDTO> getAll() {
        return documentTypeService.getAllDocumentTypes().stream()
                .map(dt -> new DocumentTypeDTO(dt.getId(), dt.getTypeName(),
                        dt.getDescription(), dt.getRequired(), dt.getWeight()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DocumentTypeDTO get(@PathVariable Long id) {
        DocumentType dt = documentTypeService.getDocumentType(id);
        return new DocumentTypeDTO(dt.getId(), dt.getTypeName(),
                dt.getDescription(), dt.getRequired(), dt.getWeight());
    }
}
