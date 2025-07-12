package edu.icet.demo.controller;

import edu.icet.demo.dto.PatientRequestDTO;
import edu.icet.demo.dto.PatientResponseDTO;
import edu.icet.demo.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
@Slf4j
public class PatientController{

     public final PatientService service;

     @PostMapping
     public void savePatients(@RequestBody  @Valid PatientRequestDTO requestDTO){
           service.savePatient(requestDTO);
           log.debug("done");

     }
     @GetMapping("/{nicNumber}")
     public PatientResponseDTO retrivePatient(@PathVariable String nicNumber ){
         return service.retrivePatients(nicNumber);

     }

     @PutMapping("/{id}")
     public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id, @RequestBody PatientRequestDTO dto){
         PatientResponseDTO patientResponseDTO = service.updatePatient(id, dto);
         return ResponseEntity.ok(patientResponseDTO);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Void> deletePatient(@PathVariable UUID id){
          service.deletePatient(id);
          return ResponseEntity.noContent().build();
     }




}
