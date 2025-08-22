package com.careNcure.backend.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.careNcure.backend.exception.NoDataFoundException;
import com.careNcure.backend.hospital.Hospital;
import com.careNcure.backend.hospital.HospitalRepo;
import com.careNcure.backend.payLoads.DoctorDTO;
import com.careNcure.backend.speciality.SpecialityRepo;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepo doctorRepo;
	@Autowired
	private SpecialityRepo specialityRepo;
	@Autowired HospitalRepo hospitalRepo;
	
	public Doctor addDoctor(DoctorDTO doctorDTO,MultipartFile image) {
		Doctor doctor=new Doctor();
		Hospital hospital=hospitalRepo.findById(doctorDTO.getHospital()).orElseThrow(()->new NoDataFoundException("Invalid Hospital"));
		doctor.setFees(doctorDTO.getFees());
		doctor.setSpeciality(specialityRepo.findBySpecialityAndHospital(doctorDTO.getSpeciality(),hospital).orElseThrow(()->new NoDataFoundException("invalid speciality")));
		doctor.setHospital(hospital);
		doctor.setemail(doctorDTO.getemail());
		doctor.setName(doctorDTO.getName());
		return doctorRepo.save(doctor);
	}
	
	private String generateId(String speciality) {
		long count=doctorRepo.countBySpeciality(specialityRepo.findById(speciality).orElseThrow(()->new NoDataFoundException("invalid speciality")));
		count++;
		return "DOC"+speciality.substring(0, 3).toUpperCase()+ String.format("%03d", count);
	}
}
