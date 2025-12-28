package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "document_types")
public class DocumentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int weight;
    private boolean required;
    private LocalDateTime createdAt;
    @ManyToMany(mappedBy = "supportedDocumentTypes")
    private Set<Vendor> vendors = new HashSet<>();
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
    public Long getId() {
         return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getWeight() { return weight; }
    public void setWeight(int weight) { this.weight = weight; }

    public boolean getRequired() { return required; }
    public void setRequired(boolean required) { this.required = required; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    public Set<Vendor> getVendors() { return vendors; }
    public void setVendors(Set<Vendor> vendors) { this.vendors = vendors; }
}
