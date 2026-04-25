package com.pms.patient_service.service.impl;

import com.pms.patient_service.dto.PatientResponseDTO;
import com.pms.patient_service.mapper.PatientMapper;
import com.pms.patient_service.module.Patient;
import com.pms.patient_service.repository.PatientRepository;
import com.pms.patient_service.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public List<PatientResponseDTO> getPatient(){
        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::toDTO)
                .toList();
    }
}
