package edu.icet.demo.controller;

import edu.icet.demo.dto.PatientResponseDTO;
import edu.icet.demo.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patinet")
@RequiredArgsConstructor
public class PatientController {

    private static PatientService service;


    @GetMapping
    public List<PatientResponseDTO> getPatient(){
        return  service.getPatient();
    }

}
