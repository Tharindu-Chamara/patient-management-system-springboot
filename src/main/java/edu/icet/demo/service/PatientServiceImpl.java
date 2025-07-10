package edu.icet.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.dto.PatientRequestDTO;
import edu.icet.demo.dto.PatientResponseDTO;
import edu.icet.demo.exception.EmailAlreadyExistsException;
import edu.icet.demo.model.PatientEntity;
import edu.icet.demo.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private  final PatientRepository repository;
    private final ObjectMapper mapper;


    @Override
    public void savePatient(PatientRequestDTO requestDTO) {
        if(repository.existsByEmail(requestDTO.getEmail())){
            throw new EmailAlreadyExistsException
                    ("A patient with this email already exists" +requestDTO.getEmail());
        }
        repository.save(mapper.convertValue(requestDTO, PatientEntity.class));

    }

    @Override
    public PatientResponseDTO retrivePatients(String nicNumber) {
        List<PatientEntity> allByNic = repository.findByNic(nicNumber);
        return mapper.convertValue(allByNic, PatientResponseDTO.class);

    }


    @Override
    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO){
        PatientEntity patientEntity = repository.findById(id)
                .orElseThrow(() -> new EmailAlreadyExistsException("patient not found with this id " + id));

        patientEntity.setName(patientRequestDTO.getName());
        patientEntity.setNic(patientRequestDTO.getNic());
        patientEntity.setEmail(patientRequestDTO.getEmail());
        patientEntity.setAddress(patientRequestDTO.getAddress());
        patientEntity.setRegisterDate(patientRequestDTO.getRegisterDate());
        patientEntity.setDateOfBirth(patientRequestDTO.getDateOfBirth());

        PatientEntity save = repository.save(patientEntity);
        return mapper.convertValue(save,PatientResponseDTO.class);

    }



}
