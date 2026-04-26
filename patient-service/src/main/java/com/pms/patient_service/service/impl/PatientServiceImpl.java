package com.pms.patient_service.service.impl;

import com.pms.patient_service.dto.PatientRequestDTO;
import com.pms.patient_service.dto.PatientResponseDTO;
import com.pms.patient_service.exception.EmailAlreadyExistsException;
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

    public List<PatientResponseDTO> getPatients(){
        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::toDTO)
                .toList();
    }

    @Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {

        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient of this email already exists "+patientRequestDTO.getEmail());
        }
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }
}
