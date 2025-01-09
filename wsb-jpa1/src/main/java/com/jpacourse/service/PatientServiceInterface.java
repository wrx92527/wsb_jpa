package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;

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

    public void deletePatientById(Long id);

    public List<VisitTO> findVisitsByPatientId(Long patientId);
}
