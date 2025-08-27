package com.careNcure.backend.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careNcure.backend.payLoads.ApiResponse;
import com.careNcure.backend.payLoads.registrationDto.PatientRegistrationDTO;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse> registerPatient(@RequestBody PatientRegistrationDTO patient){
		try {
			patientService.registerPatient(patient);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Registration successful", true));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage(), false));
		}
	}
}
