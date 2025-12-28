package com.example.demo.dto;
	
public class DocumentTypeDTO {

    private Long id;
    private String name;
    private boolean required;
    private int weight;

    public DocumentTypeDTO() {
    }

    public DocumentTypeDTO(Long id, String name, boolean required, int weight) {
        this.id = id;
        this.name = name;
        this.required = required;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
