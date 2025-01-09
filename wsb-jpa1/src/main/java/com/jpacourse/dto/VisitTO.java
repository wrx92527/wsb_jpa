package com.jpacourse.dto;

import java.time.LocalDateTime;
import java.util.List;

public class VisitTO {
    private Long id;
    private LocalDateTime time;
    private String doctorFirstName;
    private String doctorLastName;
    private List<String> treatmentTypes;
    private final String description;

    public VisitTO(
        Long id,
        LocalDateTime time,
        String doctorFirstName,
        String doctorLastName,
        List<String> treatmentTypes,
        String description
    ) {
        this.id = id;
        this.time = time;
        this.doctorFirstName = doctorFirstName;
        this.doctorLastName = doctorLastName;
        this.treatmentTypes = treatmentTypes;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public List<String> getTreatmentTypes() {
        return treatmentTypes;
    }

    public String getDescription() {
        return description;
    }
}