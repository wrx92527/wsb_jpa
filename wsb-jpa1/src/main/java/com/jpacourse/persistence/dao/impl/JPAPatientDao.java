package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JPAPatientDao extends AbstractDao<PatientEntity, Long> implements PatientDao {

    public VisitEntity scheduleVisit(Long patientId, Long doctorId, LocalDateTime date, String description) {
        PatientEntity patient = entityManager.find(PatientEntity.class, patientId);

        if (patient == null) {
            throw new IllegalArgumentException("Patient with ID " + patientId + " not found.");
        }

        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);

        if (doctor == null) {
            throw new IllegalArgumentException("Doctor with ID " + doctorId + " not found.");
        }

        VisitEntity visit = new VisitEntity();
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setTime(date);
        visit.setDescription(description);

        patient
            .getVisits()
            .add(visit);

        entityManager.merge(patient);

        return visit;
    }

    public List<PatientEntity> findPatientsByLastName(String lastName) {
        return entityManager
            .createQuery("SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
            .setParameter("lastName", lastName)
            .getResultList();
    }

    public List<PatientEntity> findPatientsWithMoreThanXVisits(int visitCount) {
        return entityManager
            .createQuery(
                "SELECT p FROM PatientEntity p WHERE SIZE(p.visits) > :visitCount", PatientEntity.class)
            .setParameter("visitCount", visitCount)
            .getResultList();
    }

    public List<PatientEntity> findPatientsByInsuranceStatus(boolean insured) {
        return entityManager
            .createQuery("SELECT p FROM PatientEntity p WHERE p.insured = :insured", PatientEntity.class)
            .setParameter("insured", insured)
            .getResultList();
    }
}
