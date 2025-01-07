package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "visit")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@Column(nullable = false)
	private LocalDateTime time;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(
		name = "doctor_id",
		nullable = false,
		foreignKey = @ForeignKey(name = "fk_visit_doctor")
	)
	private DoctorEntity doctor;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(
		name = "patient_id",
		nullable = false,
		foreignKey = @ForeignKey(name = "fk_visit_patient")
	)
	private PatientEntity patient;

	//Relacja od strony rodzica (visit to rodzic)
	@OneToMany(
		mappedBy = "visit",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	private List<MedicalTreatmentEntity> medicalTreatments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public List<MedicalTreatmentEntity> getMedicalTreatments() {
        return medicalTreatments;
    }

    public void setMedicalTreatments(List<MedicalTreatmentEntity> medicalTreatments) {
        this.medicalTreatments = medicalTreatments;
    }
}
