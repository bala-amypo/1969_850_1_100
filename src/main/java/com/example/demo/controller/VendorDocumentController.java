package com.example.demo.controller;

import com.example.demo.model.VendorDocument;
import com.example.demo.service.VendorDocumentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor-documents")
public class VendorDocumentController {

    private final VendorDocumentService service;

    public VendorDocumentController(VendorDocumentService service) {
        this.service = service;
    }

    @PostMapping("/upload/{vendorId}/{typeId}")
    public VendorDocument upload(
            @PathVariable Long vendorId,
            @PathVariable Long typeId,
            @RequestBody VendorDocument document
    ) {
        return service.uploadDocument(vendorId, typeId, document);
    }

    @GetMapping("/vendor/{vendorId}")
    public List<VendorDocument> getByVendor(@PathVariable Long vendorId) {
        return service.getDocumentsForVendor(vendorId);
    }

    @GetMapping("/{id}")
    public VendorDocument getOne(@PathVariable Long id) {
        return service.getDocument(id);
    }
}
