package com.example.demo.service.impl;

import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl {
    private final VendorRepository repo;

    public VendorServiceImpl(VendorRepository repo) {
        this.repo = repo;
    }

    public Vendor createVendor(Vendor v) {
        return repo.save(v);
    }

    public Vendor getVendor(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));
    }
}
