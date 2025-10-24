package com.careNcure.backend.speciality;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepo extends JpaRepository<Speciality, Integer>{
	Optional<Speciality> findBySpecialityAndHospital_Id(String speciality, int id);
	List<Speciality> findByHospitalId(int id);
	
}
