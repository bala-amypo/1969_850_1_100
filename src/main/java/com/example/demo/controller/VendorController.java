package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dto.VendorDTO;
import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public VendorDTO createVendor(@RequestBody VendorDTO dto) {
        Vendor vendor = new Vendor(dto.getVendorName(), dto.getEmail(),
                dto.getPhone(), dto.getIndustry());
        Vendor saved = vendorService.createVendor(vendor);

        return new VendorDTO(saved.getId(), saved.getVendorName(),
                saved.getEmail(), saved.getPhone(), saved.getIndustry());
    }

    @GetMapping
    public List<VendorDTO> getAllVendors() {
        return vendorService.getAllVendors().stream()
                .map(v -> new VendorDTO(v.getId(), v.getVendorName(),
                        v.getEmail(), v.getPhone(), v.getIndustry()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VendorDTO getVendor(@PathVariable Long id) {
        Vendor v = vendorService.getVendor(id);
        return new VendorDTO(v.getId(), v.getVendorName(),
                v.getEmail(), v.getPhone(), v.getIndustry());
    }
}
