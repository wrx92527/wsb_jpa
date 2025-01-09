package com.jpacourse.service;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientServiceInterface patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Test
    public void testShouldDeletePatientAndCascadeVisitsButNotDoctors() {
        PatientEntity patient = entityManager.find(PatientEntity.class, 1L);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, 1L);

        assertThat(patient).isNotNull();
        assertThat(doctor).isNotNull();

        VisitEntity visit = new VisitEntity();
        visit.setTime(LocalDateTime.now());
        visit.setDescription("Routine Checkup");
        visit.setDoctor(doctor);
        visit.setPatient(patient);

        patient
            .getVisits()
            .add(visit);
        patientDao.save(patient);

        patientService.deletePatientById(patient.getId());

        assertThat(patientDao.findOne(patient.getId())).isNull();
        assertThat(entityManager.find(VisitEntity.class, visit.getId())).isNull();
        assertThat(entityManager.find(DoctorEntity.class, doctor.getId())).isNotNull();
    }

    @Transactional
    @Test
    public void testShouldReturnPatientTOWithCorrectStructure() {
        PatientEntity patient = entityManager.find(PatientEntity.class, 1L);
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, 1L);

        assertThat(patient).isNotNull();
        assertThat(doctor).isNotNull();

        VisitEntity visit = new VisitEntity();
        visit.setTime(LocalDateTime.now());
        visit.setDescription("Routine Checkup");
        visit.setDoctor(doctor);
        visit.setPatient(patient);

        patient
            .getVisits()
            .add(visit);
        patientDao.save(patient);

        PatientTO patientTO = patientService.getPatientById(patient.getId());

        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getFirstName()).isEqualTo(patient.getFirstName());
        assertThat(patientTO.getLastName()).isEqualTo(patient.getLastName());
        assertThat(patientTO.isInsured()).isEqualTo(patient.isInsured());
        assertThat(patientTO.getVisits()).hasSize(4);

        VisitTO visitTO = patientTO
            .getVisits()
            .get(0);
        assertThat(visitTO.getDoctorFirstName()).isEqualTo(doctor.getFirstName());
        assertThat(visitTO.getDoctorLastName()).isEqualTo(doctor.getLastName());
        assertThat(visitTO.getTreatmentTypes()).hasSize(1);
    }

    @Transactional
    @Test
    public void testFindVisitsByPatientId() {
        List<VisitTO> visits = patientService.findVisitsByPatientId(1L);
        assertThat(visits).hasSize(2);
        assertThat(visits
            .get(0)
            .getDescription()).isEqualTo("Wizyta kontrolna serca");
    }
}