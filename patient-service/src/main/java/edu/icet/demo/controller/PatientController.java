package edu.icet.demo.controller;

import edu.icet.demo.dto.PatientRequestDTO;
import edu.icet.demo.dto.PatientResponseDTO;
import edu.icet.demo.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient-request")
@CrossOrigin
public class PatientController {

    private  PatientService service;

    PatientController(PatientService service1){
        this.service=service1;
    }


    @GetMapping
    public List<PatientResponseDTO> getPatient(){
        return  service.getPatient();
    }

    @PostMapping
    public void savePatient (@Valid @RequestBody PatientRequestDTO requestDTO){
        service.savePatient(requestDTO);
    }

}
