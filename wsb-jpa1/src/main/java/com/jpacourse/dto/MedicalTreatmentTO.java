package com.jpacourse.dto;

public class MedicalTreatmentTO {
    private Long id;
    private String description;
    private String type;

    public MedicalTreatmentTO(
        Long id,
        String description,
        String type
    ) {
        this.id = id;
        this.description = description;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}