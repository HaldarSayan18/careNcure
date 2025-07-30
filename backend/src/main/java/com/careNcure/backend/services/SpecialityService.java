package com.careNcure.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careNcure.backend.entities.Speciality;
import com.careNcure.backend.repos.SpecialityRepo;

@Service
public class SpecialityService {
	@Autowired
	private SpecialityRepo specialityRepo;

	public List<Speciality> getAllSpeciality() {
		return specialityRepo.findAll();
	}

	public Speciality addSpeciality(Speciality speciality) {
		return specialityRepo.save(speciality);
	}
	
	public Speciality findSpeciality(int id) {
		return specialityRepo.findById(id).orElse(null);
	}
}
