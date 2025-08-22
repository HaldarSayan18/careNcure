package com.careNcure.backend.speciality;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careNcure.backend.exception.DataAlreadyExistsException;
import com.careNcure.backend.exception.NoDataFoundException;
import com.careNcure.backend.hospital.Hospital;
import com.careNcure.backend.hospital.HospitalRepo;
import com.careNcure.backend.payLoads.SpecialityDTO;

@Service
public class SpecialityService {
	@Autowired
	private SpecialityRepo specialityRepo;
	@Autowired
	private HospitalRepo hospitalRepo;
	
	public Speciality addSpeciality(SpecialityDTO specialityDTO){
		if(specialityDTO.getSpeciality().isEmpty())
			throw new IllegalArgumentException("speciality can not be empty");
		else if(specialityDTO.getHospital()==0)
			throw new IllegalArgumentException("Hospital can not be empty");
		else if(specialityRepo.existsById(specialityDTO.getSpeciality()))
			throw new DataAlreadyExistsException("speciality already exists");
		Hospital hospital=hospitalRepo.findById(specialityDTO.getHospital()).orElseThrow(()->new NoDataFoundException("Invalid hospital"));
		Speciality speciality=new Speciality();
		speciality.setSpeciality(specialityDTO.getSpeciality());
		speciality.setHospital(hospital);
		return specialityRepo.save(speciality);
	}
	
	public List<Speciality> getAllSpeciality(){
		return specialityRepo.findAll();
	}
}
