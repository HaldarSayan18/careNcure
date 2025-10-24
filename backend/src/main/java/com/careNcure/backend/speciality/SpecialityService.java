package com.careNcure.backend.speciality;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		else if(specialityRepo.findBySpecialityAndHospital_Id(specialityDTO.getSpeciality(), specialityDTO.getHospital()).isPresent())
			throw new DataAlreadyExistsException("speciality already exists");
		Hospital hospital=hospitalRepo.findById(specialityDTO.getHospital()).orElseThrow(()->new NoDataFoundException("Invalid hospital"));
		Speciality speciality=new Speciality();
		speciality.setSpeciality(specialityDTO.getSpeciality());
		speciality.setHospital(hospital);
		return specialityRepo.save(speciality);
	}
	
	public Map<Integer, Map<String, Object>> getAllSpeciality(int id){
		List<Speciality> specialityList= specialityRepo.findByHospitalId(id);
		System.out.println(specialityList.size());
		Map<Integer, Map<String, Object>> response=new HashMap<Integer, Map<String, Object>>();
		int i=0;
		for(Speciality speciality:specialityList) {
			Map<String,Object> desc=new LinkedHashMap<String,Object>();
			desc.put("Speciality", speciality.getSpeciality());
			desc.put("Hospital", speciality.getHospital().getId());
			System.out.println("Adding speciality: " + speciality.getSpeciality() + " at index " + i);
			response.put(i, desc);
			i++;
		}
		return response;
	}
}
