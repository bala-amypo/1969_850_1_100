package com.example.demo.controller;

import com.example.demo.model.VendorDocument;
import com.example.demo.service.VendorDocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendor-documents")
public class VendorDocumentController {

    private final VendorDocumentService vendorDocumentService;

    public VendorDocumentController(VendorDocumentService vendorDocumentService) {
        this.vendorDocumentService = vendorDocumentService;
    }

    @PostMapping("/upload")
    public ResponseEntity<VendorDocument> upload(@RequestParam Long vendorId,
                                                 @RequestParam Long documentTypeId,
                                                 @RequestBody VendorDocument doc) {
        return ResponseEntity.ok(vendorDocumentService.uploadDocument(vendorId, documentTypeId, doc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorDocument> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vendorDocumentService.getDocument(id));
    }
}
