package com.careNcure.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careNcure.backend.repos.DoctorRepo;
import com.careNcure.backend.entities.Doctor;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepo doctorRepo;
	
	public List<Doctor> getAllDoctorsList(){
		return doctorRepo.findAll();
	}
	
	public Doctor addDoctor(Doctor doctor) {
		try {
			return doctorRepo.save(doctor);
		}catch(Exception e) {
			return null;
		}
	}
}
