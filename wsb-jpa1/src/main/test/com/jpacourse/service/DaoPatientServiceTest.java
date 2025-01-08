import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.enums.Specialization;
import com.jpacourse.service.DaoPatientService;
import com.jpacourse.service.to.PatientTO;
import com.jpacourse.service.to.VisitTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DaoPatientServiceTest {

    @Autowired
    private DaoPatientService patientService;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private VisitDao visitDao;

    @Transactional
    @Test
    public void testShouldDeletePatientAndCascadeVisitsButNotDoctors() {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setTelephoneNumber("123456789");
        patient.setEmail("john.doe@example.com");
        patient.setPatientNumber("P001");
        patient.setDateOfBirth(LocalDate.of(1980, 1, 1));
        patient.setInsured(true);

        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Alice");
        doctor.setLastName("Smith");
        doctor.setTelephoneNumber("987654321");
        doctor.setEmail("alice.smith@example.com");
        doctor.setDoctorNumber("D001");
        doctor.setSpecialization(Specialization.CARDIOLOGY);

        VisitEntity visit = new VisitEntity();
        visit.setTime(LocalDateTime.now());
        visit.setDescription("Routine Checkup");
        visit.setDoctor(doctor);
        visit.setPatient(patient);

        patient.setVisits(List.of(visit));

        patientDao.save(patient);
        doctorDao.save(doctor);

        patientService.deletePatientById(patient.getId());

        assertThat(patientDao.findById(patient.getId())).isEmpty();
        assertThat(visitDao.findByPatientId(patient.getId())).isEmpty();
        assertThat(doctorDao.findById(doctor.getId())).isPresent();
    }

    @Transactional
    @Test
    public void testShouldReturnPatientTOWithCorrectStructure() {
        PatientEntity patient = new PatientEntity();
        patient.setFirstName("John");
        patient.setLastName("Doe");
        patient.setTelephoneNumber("123456789");
        patient.setEmail("john.doe@example.com");
        patient.setPatientNumber("P001");
        patient.setDateOfBirth(LocalDate.of(1980, 1, 1));
        patient.setInsured(true);

        DoctorEntity doctor = new DoctorEntity();
        doctor.setFirstName("Alice");
        doctor.setLastName("Smith");
        doctor.setTelephoneNumber("987654321");
        doctor.setEmail("alice.smith@example.com");
        doctor.setDoctorNumber("D001");
        doctor.setSpecialization(Specialization.CARDIOLOGY);

        VisitEntity visit = new VisitEntity();
        visit.setTime(LocalDateTime.now());
        visit.setDescription("Routine Checkup");
        visit.setDoctor(doctor);
        visit.setPatient(patient);

        patient.setVisits(List.of(visit));

        patientDao.save(patient);

        PatientTO patientTO = patientService.getPatientById(patient.getId());

        assertThat(patientTO).isNotNull();
        assertThat(patientTO.getFirstName()).isEqualTo("John");
        assertThat(patientTO.getLastName()).isEqualTo("Doe");
        assertThat(patientTO.isInsured()).isTrue();
        assertThat(patientTO.getVisits()).hasSize(1);

        VisitTO visitTO = patientTO
            .getVisits()
            .get(0);
        assertThat(visitTO.getDoctorFirstName()).isEqualTo("Alice");
        assertThat(visitTO.getDoctorLastName()).isEqualTo("Smith");
    }
}
