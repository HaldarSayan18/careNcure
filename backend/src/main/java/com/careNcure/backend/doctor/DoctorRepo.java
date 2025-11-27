package com.careNcure.backend.doctor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DoctorRepo extends JpaRepository<Doctor, String> {
	Page<Doctor> findByHospitalId(int hospitalId,Pageable pageable);
	long countBySpeciality_IdAndHospital_Id(int speciality,int hospital);
}
