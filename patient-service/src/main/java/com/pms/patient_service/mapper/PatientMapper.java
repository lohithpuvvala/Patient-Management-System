package com.pms.patient_service.mapper;

import com.pms.patient_service.dto.PatientResponseDTO;
import com.pms.patient_service.module.Patient;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient) {
        return PatientResponseDTO.builder()
                .id(patient.getId().toString())
                .name(patient.getName())
                .email(patient.getEmail())
                .address(patient.getAddress())
                .dateOfBirth(patient.getDateOfBirth().toString())
                .build();
    }
}
