package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "document_types", uniqueConstraints = {
        @UniqueConstraint(columnNames = "typeName")
})
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;
    private String description;
    private Boolean required;
    private Integer weight;

    private LocalDateTime createdAt;

    public DocumentType() {}

    public DocumentType(String typeName, String description, Boolean required, Integer weight) {
        this.typeName = typeName;
        this.description = description;
        this.required = required;
        this.weight = weight;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.weight == null) {
            this.weight = 0;
        }
    }

    // getters and setters
}
