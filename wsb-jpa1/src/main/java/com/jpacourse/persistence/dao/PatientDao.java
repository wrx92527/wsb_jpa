package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    public VisitEntity scheduleVisit(Long patientId, Long doctorId, LocalDateTime date, String description);

    public List<PatientEntity> findPatientsByLastName(String lastName);

    public List<PatientEntity> findPatientsWithMoreThanXVisits(int visitCount);

    public List<PatientEntity> findPatientsByInsuranceStatus(boolean insured);
}
