package com.jpacourse.dto;

import java.time.LocalDate;
import java.util.List;

public class PatientTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String patientNumber;
    private LocalDate dateOfBirth;
    private AddressTO address;
    private List<VisitTO> visits;
    private boolean insured;

    public PatientTO(
        Long id,
        String firstName,
        String lastName,
        String telephoneNumber,
        String email,
        String patientNumber,
        LocalDate dateOfBirth,
        AddressTO address,
        List<VisitTO> visits,
        boolean insured
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.patientNumber = patientNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.visits = visits;
        this.insured = insured;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public AddressTO getAddress() {
        return address;
    }

    public List<VisitTO> getVisits() {
        return visits;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }
}