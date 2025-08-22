package com.careNcure.backend.speciality;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careNcure.backend.hospital.Hospital;

@Repository
public interface SpecialityRepo extends JpaRepository<Speciality, String>{
	Optional<Speciality> findBySpecialityAndHospital(String speciality, Hospital hospital);
	
}
