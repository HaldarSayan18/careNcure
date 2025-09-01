package com.careNcure.backend.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer>{
    Patient findByMobile(long mobile);
    Patient findByEmail(String email);
}