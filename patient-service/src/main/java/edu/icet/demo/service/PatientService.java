package edu.icet.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.dto.PatientResponseDTO;
import edu.icet.demo.model.Patient;
import edu.icet.demo.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    PatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    PatientService(PatientRepository repository){
        this.patientRepository=repository;
    }

    public List<PatientResponseDTO> getPatient(){
        List<Patient> all = patientRepository.findAll();
        List<PatientResponseDTO> list= new ArrayList<>();

        all.forEach(patient -> {
            PatientResponseDTO patientResponseDTO = mapper.convertValue(patient, PatientResponseDTO.class);
            list.add(patientResponseDTO);
        });
        return list;
 }

}
