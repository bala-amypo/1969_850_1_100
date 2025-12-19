package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "document_types")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Document type name is required")
    @Column(unique = true, nullable = false)
    private String typeName;

    private String description;

    @Column(nullable = false)
    private Boolean required;

    @Min(value = 0, message = "Weight must be zero or positive")
    private Integer weight;

    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "supportedDocumentTypes")
    private Set<Vendor> vendors;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public DocumentType() {}

    // getters and setters
    public Long getId() { return id; }

    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Boolean getRequired() { return required; }
    public void setRequired(Boolean required) { this.required = required; }

    public Integer getWeight() { return weight; }
    public void setWeight(Integer weight) { this.weight = weight; }

    public Set<Vendor> getVendors() { return vendors; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}