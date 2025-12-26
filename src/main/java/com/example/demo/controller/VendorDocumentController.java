package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.VendorDocumentDTO;
import com.example.demo.model.VendorDocument;
import com.example.demo.service.VendorDocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendor-documents")
public class VendorDocumentController {

    private final VendorDocumentService vendorDocumentService;

    @Autowired
    public VendorDocumentController(VendorDocumentService vendorDocumentService) {
        this.vendorDocumentService = vendorDocumentService;
    }

    @PostMapping("/upload")
    public VendorDocumentDTO uploadDocument(@RequestParam Long vendorId,
                                            @RequestParam Long typeId,
                                            @RequestBody VendorDocumentDTO dto) {
        VendorDocument vd = new VendorDocument();
        vd.setFileUrl(dto.getFileUrl());
        vd.setExpiryDate(dto.getExpiryDate());

        VendorDocument saved = vendorDocumentService.uploadDocument(vendorId, typeId, vd);
        return new VendorDocumentDTO(saved.getId(),
                saved.getVendor().getId(),
                saved.getDocumentType().getId(),
                saved.getFileUrl(),
                saved.getExpiryDate());
    }

    @GetMapping("/vendor/{vendorId}")
    public List<VendorDocumentDTO> getByVendor(@PathVariable Long vendorId) {
        return vendorDocumentService.getDocumentsForVendor(vendorId).stream()
                .map(vd -> new VendorDocumentDTO(vd.getId(),
                        vd.getVendor().getId(),
                        vd.getDocumentType().getId(),
                        vd.getFileUrl(),
                        vd.getExpiryDate()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VendorDocumentDTO get(@PathVariable Long id) {
        VendorDocument vd = vendorDocumentService.getDocument(id);
        return new VendorDocumentDTO(vd.getId(),
                vd.getVendor().getId(),
                vd.getDocumentType().getId(),
                vd.getFileUrl(),
                vd.getExpiryDate());
    }
}
