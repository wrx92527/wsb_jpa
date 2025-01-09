package com.jpacourse.persistance.dao;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.PatientEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Transactional
    @Test
    public void testFindPatientsByLastName() {
        List<PatientEntity> patients = patientDao.findPatientsByLastName("Wiśniewski");
        assertThat(patients).hasSize(1);
        assertThat(patients
            .get(0)
            .getFirstName()).isEqualTo("Tomasz");
    }

    @Transactional
    @Test
    public void testFindPatientsWithMoreThanXVisits() {
        List<PatientEntity> patients = patientDao.findPatientsWithMoreThanXVisits(1);
        assertThat(patients).hasSize(1);
        assertThat(patients
            .get(0)
            .getFirstName()).isEqualTo("Tomasz");
    }

    @Transactional
    @Test
    public void testFindPatientsByInsuranceStatus() {
        List<PatientEntity> patients = patientDao.findPatientsByInsuranceStatus(true);
        assertThat(patients).hasSize(2);
        assertThat(patients
            .get(0)
            .getLastName()).isEqualTo("Wiśniewski");
    }
}