package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.impl.VendorServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    private final VendorServiceImpl vendorService;

    public VendorController(VendorServiceImpl vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @GetMapping("/{id}")
    public Vendor getVendor(@PathVariable Long id) {
        return vendorService.getVendor(id);
    }
}
