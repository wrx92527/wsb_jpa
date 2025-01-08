package com.jpacourse.dto;

public class DoctorTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String doctorNumber;
    private String specialization;

    public DoctorTO(
        Long id,
        String firstName,
        String lastName,
        String telephoneNumber,
        String email,
        String doctorNumber,
        String specialization
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.doctorNumber = doctorNumber;
        this.specialization = specialization;
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

    public String getDoctorNumber() {
        return doctorNumber;
    }

    public String getSpecialization() {
        return specialization;
    }
}
