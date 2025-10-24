package com.careNcure.backend.doctor;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.careNcure.backend.config.FileStorageService;
import com.careNcure.backend.exception.NoDataFoundException;
import com.careNcure.backend.hospital.Hospital;
import com.careNcure.backend.hospital.HospitalRepo;
import com.careNcure.backend.payLoads.DoctorDTO;
import com.careNcure.backend.speciality.Speciality;
import com.careNcure.backend.speciality.SpecialityRepo;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepo doctorRepo;
	@Autowired
	private SpecialityRepo specialityRepo;
	@Autowired 
	private HospitalRepo hospitalRepo;
	@Autowired
	private FileStorageService fileStorageService;
	
	public Doctor addDoctor(DoctorDTO doctorDTO,MultipartFile image) {
		Doctor doctor=new Doctor();
		Hospital hospital=hospitalRepo.findById(doctorDTO.getHospital()).orElseThrow(()->new NoDataFoundException("Invalid Hospital"));
		Speciality speciality=specialityRepo.findBySpecialityAndHospital_Id(doctorDTO.getSpeciality(),hospital.getId()).orElseThrow(()->new NoDataFoundException("Invalid Speciality"));
		String docId=generateId(speciality,hospital);
		doctor.setId(docId);
		doctor.setFees(doctorDTO.getFees());
		doctor.setSpeciality(speciality);
		doctor.setHospital(hospital);
		doctor.setEmail(doctorDTO.getEmail());
		doctor.setFirstName(doctorDTO.getFirstName());
		doctor.setLastName(doctorDTO.getLastName());
		doctor.setMobileNo(doctorDTO.getMobile());
		try {
			doctor.setImageUrl("/uploads/doctor/"+fileStorageService.saveDoctorImage(image, docId));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doctorRepo.save(doctor);
	}
	
	public Map<Integer, Map<String, Object>> getDoctorList(){
		List<Doctor> doctorList=doctorRepo.findAll();
		Map<Integer, Map<String, Object>> response=new HashMap<Integer, Map<String, Object>>();
		int i=0;
		for(Doctor doctor:doctorList) {
			Map<String, Object> entity=new HashMap<String, Object>();
			entity.put("FirstName",doctor.getFirstName());
			entity.put("LastName", doctor.getLastName());
			entity.put("Email",doctor.getEmail());
			entity.put("Id", doctor.getId());
			entity.put("Fees", doctor.getFees());
			entity.put("HospitalId", doctor.getHospital().getId()+"");
			entity.put("HospitalName", doctor.getHospital().getName());
			entity.put("Speciality", doctor.getSpeciality().getSpeciality());
			entity.put("Mobile", doctor.getMobileNo());
			entity.put("Image", doctor.getImageUrl());
			response.put(i, entity);
			i++;
		}
		return response;
	}
	
	public DoctorDTO getDoctor(String id) {
		Doctor doctor=doctorRepo.findById(id).orElseThrow(()->new NoDataFoundException("invalid doctor id"));
		DoctorDTO response=new DoctorDTO();
		response.setEmail(doctor.getEmail());
		response.setFees(doctor.getFees());
		response.setFirstName(doctor.getFirstName());
		response.setLastName(doctor.getLastName());
		response.setHospital(doctor.getHospital().getId());
		response.setMobile(doctor.getMobileNo());
		response.setSpeciality(doctor.getSpeciality().getSpeciality());
		response.setImageUrl(doctor.getImageUrl());
		return response;
	}
	public boolean deleteDoctor(String id) {
		Doctor doctor=doctorRepo.findById(id).orElseThrow(()->new NoDataFoundException("No doctor Found"));
		doctorRepo.delete(doctor);
		return true;
	}
	
	private String generateId(Speciality speciality,Hospital hospital) {
		long count=doctorRepo.countBySpeciality_IdAndHospital_Id(speciality.getId(), hospital.getId());
		count++;
		return "HSP"+hospital.getId()+"DOC"+speciality.getSpeciality().substring(0, 3).toUpperCase()+ String.format("%04d", count);
	}
}
