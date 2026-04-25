package com.pms.patient_service.service;

import com.pms.patient_service.dto.PatientRequestDTO;
import com.pms.patient_service.dto.PatientResponseDTO;

import java.util.List;

public interface PatientService {
    public List<PatientResponseDTO> getPatients();
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);
}
