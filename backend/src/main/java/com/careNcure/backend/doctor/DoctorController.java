package com.careNcure.backend.doctor;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.careNcure.backend.payLoads.ApiResponse;
import com.careNcure.backend.payLoads.DoctorDTO;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController{
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addDoctor(@ModelAttribute DoctorDTO doctorDTO,@RequestParam("IMAGE") MultipartFile multiipartfile){
        try{
            doctorService.addDoctor(doctorDTO,multiipartfile);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Doctor added successfully",true));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage(), false));
        }
    }
    @GetMapping("/doctor-list")
    public ResponseEntity<?> getDoctors(@RequestParam int hospitalId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
    	try {
    		PageRequest pageable=PageRequest.of(page, size);
			Page<Doctor> response=doctorService.getDoctorListByHospitalId(hospitalId, pageable);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage(), false));
		}
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctor(@PathVariable String id){
    	try {
    		DoctorDTO response=doctorService.getDoctor(id);
        	return ResponseEntity.status(HttpStatus.OK).body(response);
    	}catch(Exception e) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    	}
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable String id){
    	boolean result=doctorService.deleteDoctor(id);
    	return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Deleted successfully", result));
    }

}