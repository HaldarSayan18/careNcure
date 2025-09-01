package com.careNcure.backend.speciality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careNcure.backend.payLoads.ApiResponse;
import com.careNcure.backend.payLoads.SpecialityDTO;

@RestController
@RequestMapping("/api/speciality")
public class SpecialityController {
	@Autowired
	private SpecialityService specialityService;
	
	@PostMapping(value = "/add", consumes = "application/json")
	public ResponseEntity<?> addSpeciality(@RequestBody SpecialityDTO speciality){
		try {
			specialityService.addSpeciality(speciality);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Speciality added", true));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage(), false));
		}
	}
	
}
