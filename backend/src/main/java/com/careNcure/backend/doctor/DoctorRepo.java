package com.careNcure.backend.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careNcure.backend.speciality.Speciality;
@Repository
public interface DoctorRepo extends JpaRepository<Doctor, String> {
	long countBySpeciality(Speciality speciality);
}
