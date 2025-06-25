package edu.icet.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientResponseDTO {
    private  String id;
    private  String name;
    private  String nic;
    private  String email;
    private  String address;
    private  String dataOfBirth;

}
