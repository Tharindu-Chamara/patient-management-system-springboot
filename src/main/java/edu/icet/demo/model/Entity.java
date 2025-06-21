package edu.icet.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.UUID;

@jakarta.persistence.Entity
@Setter
@Getter
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Column(unique = true)
    private String email;

    private String address;

    private LocalDate dateOfBirth;

    private LocalDate registerDate;


}
