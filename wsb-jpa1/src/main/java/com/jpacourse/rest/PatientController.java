package com.jpacourse.rest;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.service.PatientServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/patients")
public final class PatientController {

    private final PatientServiceInterface patientService;

    public PatientController(
        PatientServiceInterface patientService
    ) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientTO>> getAllPatients() {
        List<PatientTO> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientTO> getPatientById(@PathVariable Long id) {
        PatientTO patient = patientService.getPatientById(id);
        return ResponseEntity.ok(patient);
    }

    @PostMapping("/{id}/visits")
    public ResponseEntity<Void> addVisitToPatient(
        @PathVariable Long id,
        @RequestParam Long doctorId,
        @RequestParam String visitReason,
        @RequestParam String visitDate
    ) {
        LocalDateTime parsedVisitDate = LocalDateTime.parse(visitDate);

        patientService.scheduleVisit(id, doctorId, parsedVisitDate, visitReason);
        return ResponseEntity
            .ok()
            .build();
    }
}