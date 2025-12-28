package com.example.demo.service;
import java.util.List;
import com.example.demo.model.DocumentType;

public interface DocumentTypeService
{
    DocumentType createDocumentType(DocumentType type);
    List<DocumentType> getAllDocumentTypes();
    DocumentType getDocumentType(Long id);
}
