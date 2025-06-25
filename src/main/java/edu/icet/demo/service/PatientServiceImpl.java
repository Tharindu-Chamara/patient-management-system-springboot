package edu.icet.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.dto.PatientRequestDTO;
import edu.icet.demo.dto.PatientResponseDTO;
import edu.icet.demo.model.PatientEntity;
import edu.icet.demo.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private  final PatientRepository repository;
    private final ObjectMapper mapper;


    @Override
    public void savePatient(PatientRequestDTO requestDTO) {
        repository.save(mapper.convertValue(requestDTO,PatientEntity.class));

    }

    @Override
    public PatientResponseDTO retrivePatients(String nicNumber) {
        List<PatientEntity> allByNic = repository.findByNic(nicNumber);
        return mapper.convertValue(allByNic, PatientResponseDTO.class);

    }
}
