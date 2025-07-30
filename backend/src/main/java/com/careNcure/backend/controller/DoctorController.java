package com.careNcure.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.careNcure.backend.dto.DoctorDTO;
import com.careNcure.backend.entities.Doctor;
import com.careNcure.backend.entities.Speciality;
import com.careNcure.backend.services.DoctorService;
import com.careNcure.backend.services.SpecialityService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private SpecialityService specialityService;
	
	@PostMapping(value = "/add",consumes = "multipart/form-data")
	public ResponseEntity<?> addDoctor(@ModelAttribute DoctorDTO doctorDTO,@RequestParam("IMAGE") MultipartFile imageFile){
		try {
			Speciality speciality=specialityService.findSpeciality(doctorDTO.getSPECIALITY_ID());
			Doctor doctor=new Doctor();
			doctor.setNAME(doctorDTO.getNAME());
			doctor.setMOBILE_NO(doctorDTO.getMOBILE_NO());
			doctor.setEMAIL_ID(doctorDTO.getEMAIL_ID());
			doctor.setFEES(doctorDTO.getFEES());
			doctor.setSPECIALITY_ID(speciality);
			doctor.setIMAGE(imageFile.getBytes());
			Doctor savedDoctor=doctorService.addDoctor(doctor);
			return ResponseEntity.ok(savedDoctor);
		}catch(Exception e){
			return ResponseEntity.internalServerError().body("Failed to add Doctor: "+e.getMessage());
		}
	}
	
	@GetMapping("/doctors-list")
	public ResponseEntity<?> getAllDoctorsList(){
		try {
			List<Doctor> doctorsList=doctorService.getAllDoctorsList();
			return ResponseEntity.ok(doctorsList);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Unable to fetch doctors list");
		}
		
	}
}
