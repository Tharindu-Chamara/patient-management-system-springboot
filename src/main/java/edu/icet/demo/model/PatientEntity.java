package edu.icet.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@jakarta.persistence.Entity
@Setter
@Getter
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String nic;

    @Column(unique = true)
    private String email;

    private String address;

    private String  dateOfBirth;

    private String registerDate;


}
