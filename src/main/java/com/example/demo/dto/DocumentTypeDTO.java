package com.example.demo.dto;

public class DocumentTypeDTO {
    private Long id;
    private String typeName;
    private String description;
    private Boolean required;
    private Integer weight;

    public DocumentTypeDTO() {}

    public DocumentTypeDTO(Long id, String typeName, String description, Boolean required, Integer weight) {
        this.id = id;
        this.typeName = typeName;
        this.description = description;
        this.required = required;
        this.weight = weight;
    }

    // getters & setters
}
