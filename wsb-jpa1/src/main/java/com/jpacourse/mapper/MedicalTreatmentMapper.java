package com.jpacourse.mapper;

import com.jpacourse.dto.MedicalTreatmentTO;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import org.springframework.stereotype.Component;

@Component
public class MedicalTreatmentMapper {
    public MedicalTreatmentTO mapToTO(MedicalTreatmentEntity entity) {
        return new MedicalTreatmentTO(
            entity.getId(),
            entity.getDescription(),
            entity.getType().name()
        );
    }
}