package edu.icet.demo.service;

import edu.icet.demo.dto.PatientRequestDTO;
import edu.icet.demo.dto.PatientResponseDTO;

import java.util.UUID;

public interface PatientService {
    public void savePatient(PatientRequestDTO requestDTO);

    public PatientResponseDTO retrivePatients(String nicNumber);


    PatientResponseDTO updatePatient(UUID id, PatientRequestDTO requestDTO);

    public  void deletePatient(UUID id);
}