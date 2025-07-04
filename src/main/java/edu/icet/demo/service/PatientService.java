package edu.icet.demo.service;

import edu.icet.demo.dto.PatientRequestDTO;
import edu.icet.demo.dto.PatientResponseDTO;

public interface PatientService {
    public void savePatient(PatientRequestDTO requestDTO);

    public PatientResponseDTO retrivePatients(String nicNumber);


}