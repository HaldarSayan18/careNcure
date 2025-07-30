package com.careNcure.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careNcure.backend.entities.Speciality;
import com.careNcure.backend.services.SpecialityService;

@RestController
@RequestMapping("/api/speciality")
public class SpecialityController {
	@Autowired
	private SpecialityService specialityService;

	@GetMapping("/allSpecialities")
	public List<Speciality> allSpecialities() {
		return specialityService.getAllSpeciality();
	}
	
	@PostMapping("/add-speciality")
	public ResponseEntity<?> addSpeciality(@RequestBody Speciality speciality){
		try {
			Speciality addedSpeciality=specialityService.addSpeciality(speciality);
			return ResponseEntity.ok(addedSpeciality);
		}catch(Exception e) {
			return ResponseEntity.internalServerError().body("Unable to fetch Specialities list");
		}
	}
}
