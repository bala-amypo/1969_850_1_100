package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorDocumentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;
    private final VendorDocumentRepository vendorDocumentRepository;

    // ✅ Constructor-based dependency injection
    public VendorDocumentServiceImpl(
            VendorRepository vendorRepository,
            DocumentTypeRepository documentTypeRepository,
            VendorDocumentRepository vendorDocumentRepository) {

        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
        this.vendorDocumentRepository = vendorDocumentRepository;
    }

    @Override
    public VendorDocument uploadDocument(Long vendorId, Long typeId, VendorDocument document) {

        // Load Vendor
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        // Load DocumentType
        DocumentType type = documentTypeRepository.findById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Document type not found"));

        // Business validation: fileUrl required
        if (document.getFileUrl() == null || document.getFileUrl().isBlank()) {
            throw new ValidationException("File URL is required");
        }

        // Business validation: expiry must be future
        if (document.getExpiryDate() != null &&
                document.getExpiryDate().isBefore(LocalDate.now())) {
            throw new ValidationException("Expiry date cannot be in the past");
        }

        // Set relations and metadata
        document.setVendor(vendor);
        document.setDocumentType(type);
        document.setUploadedAt(LocalDateTime.now());
        document.setIsValid(true);

        return vendorDocumentRepository.save(document);
    }

    @Override
    public List<VendorDocument> getDocumentsForVendor(Long vendorId) {
        return vendorDocumentRepository.findByVendor_Id(vendorId);
    }

    @Override
    public VendorDocument getDocument(Long id) {
        return vendorDocumentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor document not found"));
    }
}