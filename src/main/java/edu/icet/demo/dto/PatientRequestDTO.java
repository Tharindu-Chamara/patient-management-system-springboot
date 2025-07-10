package edu.icet.demo.dto;


import lombok.Data;

@Data
public class PatientRequestDTO {


     private String  name;
     private String  email;
     private String  nic;
     private String  address;
     private String  dateOfBirth;
     private String  registerDate; // very important to add validations



}
