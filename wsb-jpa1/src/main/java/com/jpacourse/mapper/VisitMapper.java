package com.jpacourse.mapper;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class VisitMapper {

    public VisitTO mapToTO(VisitEntity entity) {
        return new VisitTO(
            entity.getId(),
            entity.getTime(),
            entity
                .getDoctor()
                .getFirstName(),
            entity
                .getDoctor()
                .getLastName(),
            entity
                .getMedicalTreatments()
                .stream()
                .map(treatment -> treatment
                    .getType()
                    .name())
                .collect(Collectors.toList()),
            entity.getDescription()
        );
    }
}