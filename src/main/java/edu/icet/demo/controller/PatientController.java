package edu.icet.demo.controller;

import edu.icet.demo.dto.PatientRequestDTO;
import edu.icet.demo.dto.PatientResponseDTO;
import edu.icet.demo.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@Slf4j
public class PatientController {

     public final PatientService service;

     @PostMapping
     public void savePatients(@RequestBody  @Valid PatientRequestDTO requestDTO){  //this method main job is save product
           service.savePatient(requestDTO);
           log.debug("done");// to database but im use save name for
                                                                       //my comfortable
     }
     @GetMapping("/{nicNumber}")
     public PatientResponseDTO retrivePatient(@PathVariable String nicNumber ){
         return service.retrivePatients(nicNumber);

     }



}
