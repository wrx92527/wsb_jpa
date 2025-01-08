package com.jpacourse.mapper;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.PatientEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PatientMapper {
    private final AddressMapper addressMapper;
    private final VisitMapper visitMapper;

    public PatientMapper(
        AddressMapper addressMapper,
        VisitMapper visitMapper
    ) {
        this.addressMapper = addressMapper;
        this.visitMapper = visitMapper;
    }

    public PatientTO mapToTO(PatientEntity entity) {
        return new PatientTO(
            entity.getId(),
            entity.getFirstName(),
            entity.getLastName(),
            entity.getTelephoneNumber(),
            entity.getEmail(),
            entity.getPatientNumber(),
            entity.getDateOfBirth(),
            addressMapper.mapToTO(entity.getAddress()),
            entity
                .getVisits()
                .stream()
                .map(visitMapper::mapToTO)
                .collect(Collectors.toList()),
            entity.isInsured()
        );
    }
}
