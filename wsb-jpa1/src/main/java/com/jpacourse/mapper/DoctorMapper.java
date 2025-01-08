package com.jpacourse.mapper;

import com.jpacourse.dto.DoctorTO;
import com.jpacourse.persistence.entity.DoctorEntity;
import org.springframework.stereotype.Component;

@Component
public final class DoctorMapper {
    public DoctorTO mapToTO(DoctorEntity entity) {
        return new DoctorTO(
            entity.getId(),
            entity.getFirstName(),
            entity.getLastName(),
            entity.getTelephoneNumber(),
            entity.getEmail(),
            entity.getDoctorNumber(),
            entity.getSpecialization().name()
        );
    }
}

