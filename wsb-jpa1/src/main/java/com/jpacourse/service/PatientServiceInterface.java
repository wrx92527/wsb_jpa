package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientServiceInterface {
    public PatientTO getPatientById(Long id);

    public List<PatientTO> getAllPatients();

    public void scheduleVisit(
        Long patientId,
        Long doctorId,
        LocalDateTime visitDate,
        String visitReason
    );
}
