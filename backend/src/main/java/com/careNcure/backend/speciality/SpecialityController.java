package com.careNcure.backend.speciality;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/hospital/{id}")
	public ResponseEntity<?> getSpeciality(@PathVariable int id){
		Map<Integer, Map<String, Object>> response=specialityService.getAllSpeciality(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
}
