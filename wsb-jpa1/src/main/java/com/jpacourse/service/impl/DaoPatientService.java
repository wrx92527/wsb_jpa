package com.jpacourse.service.impl;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.mapper.PatientMapper;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.service.PatientServiceInterface;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DaoPatientService implements PatientServiceInterface {
    private final PatientDao patientDao;
    private final PatientMapper patientMapper;

    public DaoPatientService(PatientDao patientDao, PatientMapper patientMapper) {
        this.patientDao = patientDao;
        this.patientMapper = patientMapper;
    }

    public List<PatientTO> getAllPatients() {
        return patientDao
            .findAll()
            .stream()
            .map(patientMapper::mapToTO)
            .collect(Collectors.toList());
    }

    public PatientTO getPatientById(Long id) {
        return this.patientMapper.mapToTO(patientDao.findOne(id));
    }

    public void scheduleVisit(
        Long patientId,
        Long doctorId,
        LocalDateTime visitDate,
        String visitReason
    ) {
        patientDao.scheduleVisit(patientId, doctorId, visitDate, visitReason);
    }

    public void deletePatientById(Long id) {
        PatientEntity patient = patientDao.findOne(id);

        patientDao.delete(patient);
    }
}