package com.careNcure.backend.appoinment;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careNcure.backend.doctor.Doctor;
@Repository
public interface AppoinmentRepo extends JpaRepository<Appoinment, Integer>{
	List<Appoinment> findByBookedBy(int bookedBy);
	Appoinment findByBookedByAndDoctorAndDateAndPatientName(int bookedBy,Doctor doctor,Date date,String patientName);
}
