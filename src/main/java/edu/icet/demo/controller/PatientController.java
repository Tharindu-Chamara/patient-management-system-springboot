package edu.icet.demo.controller;

import edu.icet.demo.dto.Patient;
import edu.icet.demo.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

     private final PatientService service;

     @GetMapping
     public void getPatients(){ //1.15 min

     }

}
