package com.example.demo.service.impl;
	
import com.example.demo.model.DocumentType;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorDocument;
import com.example.demo.repository.DocumentTypeRepository;
import com.example.demo.repository.VendorDocumentRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.service.VendorDocumentService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VendorDocumentServiceImpl implements VendorDocumentService {

    private final VendorDocumentRepository vendorDocumentRepository;
    private final VendorRepository vendorRepository;
    private final DocumentTypeRepository documentTypeRepository;

    public VendorDocumentServiceImpl(
            VendorDocumentRepository vendorDocumentRepository,
            VendorRepository vendorRepository,
            DocumentTypeRepository documentTypeRepository
    ) {
        this.vendorDocumentRepository = vendorDocumentRepository;
        this.vendorRepository = vendorRepository;
        this.documentTypeRepository = documentTypeRepository;
    }

    @Override
    public VendorDocument uploadDocument(Long vendorId, Long typeId, VendorDocument document) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow();
        DocumentType type = documentTypeRepository.findById(typeId).orElseThrow();

        if (document.getExpiryDate() != null &&
            document.getExpiryDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Document expired");
        }

        document.setVendor(vendor);
        document.setDocumentType(type);
        return vendorDocumentRepository.save(document);
    }

    @Override
    public VendorDocument getDocument(Long id) {
        return vendorDocumentRepository.findById(id).orElse(null);
    }

    @Override
    public List<VendorDocument> getDocumentsForVendor(Long vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow();
        return vendorDocumentRepository.findByVendor(vendor);
    }
}


