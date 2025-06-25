package edu.icet.demo.repository;

import edu.icet.demo.model.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface
PatientRepository extends JpaRepository<PatientEntity ,UUID>{

    List<PatientEntity> findByNic(String nic);
}


