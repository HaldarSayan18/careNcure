package com.careNcure.backend.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public ResponseEntity<?> getDoctors(){
    	try {
			List doctorlist=doctorService.getDoctorList();
			return ResponseEntity.status(HttpStatus.OK).body(doctorlist);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage(), false));
		}
    }

}