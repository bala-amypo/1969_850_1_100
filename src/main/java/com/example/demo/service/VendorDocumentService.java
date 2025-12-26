package com.example.demo.service;

import java.util.List;
import com.example.demo.model.VendorDocument;

public interface VendorDocumentService {
    VendorDocument uploadDocument(Long vendorId, Long typeId, VendorDocument document);
    List<VendorDocument> getDocumentsForVendor(Long vendorId);
    VendorDocument getDocument(Long id);
}
