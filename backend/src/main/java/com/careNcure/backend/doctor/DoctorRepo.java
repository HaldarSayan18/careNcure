package com.careNcure.backend.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DoctorRepo extends JpaRepository<Doctor, String> {
	long countBySpeciality_IdAndHospital_Id(int speciality,int hospital);
}
