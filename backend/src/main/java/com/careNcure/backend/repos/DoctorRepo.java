package com.careNcure.backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careNcure.backend.entities.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}
