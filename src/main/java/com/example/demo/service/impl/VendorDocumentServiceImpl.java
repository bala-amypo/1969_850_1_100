package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class VendorDocumentServiceImpl {
    private final VendorDocumentRepository docRepo;
    private final VendorRepository vendorRepo;
    private final DocumentTypeRepository typeRepo;

    public VendorDocumentServiceImpl(VendorDocumentRepository docRepo, VendorRepository vendorRepo, DocumentTypeRepository typeRepo) {
        this.docRepo = docRepo;
        this.vendorRepo = vendorRepo;
        this.typeRepo = typeRepo;
    }

    public VendorDocument uploadDocument(Long vendorId, Long typeId, VendorDocument doc) {
        Vendor vendor = vendorRepo.findById(vendorId).orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
        DocumentType type = typeRepo.findById(typeId).orElseThrow(() -> new ResourceNotFoundException("DocumentType not found"));

        if (doc.getExpiryDate() != null && doc.getExpiryDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Expiry date cannot be in the past");
        }

        doc.setVendor(vendor);
        doc.setDocumentType(type);
        return docRepo.save(doc);
    }

    public VendorDocument getDocument(Long id) {
        return docRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("VendorDocument not found"));
    }
}
