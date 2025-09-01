package com.careNcure.backend.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careNcure.backend.payLoads.ApiResponse;
import com.careNcure.backend.payLoads.HospitalDTO;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {
	@Autowired
	private HospitalService hospitalService;
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addDoctor(@RequestBody HospitalDTO hospitalDTO){
		try {
			hospitalService.addHospital(hospitalDTO);
			return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Hospital added successfully", true));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage(), false));
		}
	}
	@GetMapping("/hospital_list")
	public ResponseEntity<List<Hospital>> getHospitalList(){
		List hList= hospitalService.getHospitalList();
		return ResponseEntity.status(HttpStatus.OK).body(hList);
	}
}
