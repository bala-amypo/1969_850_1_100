package com.example.demo.controller;

import com.example.demo.model.DocumentType;
import com.example.demo.service.DocumentTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document-types")
public class DocumentTypeController {

    private final DocumentTypeService obj;

    public DocumentTypeController(DocumentTypeService obj) {
        this.obj = obj;
    }

    @PostMapping
    public DocumentType createDocumentType(@RequestBody DocumentType type) {
        return obj.createDocumentType(type);
    }

    @GetMapping
    public List<DocumentType> getAllDocumentTypes() {
        return obj.getAllDocumentTypes();
    }

    @GetMapping("/{id}")
    public DocumentType getDocumentType(@PathVariable Long id) {
        return obj.getDocumentType(id);
    }
}
