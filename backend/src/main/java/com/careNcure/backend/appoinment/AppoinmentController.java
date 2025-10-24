package com.careNcure.backend.appoinment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careNcure.backend.payLoads.ApiResponse;
import com.careNcure.backend.payLoads.AppoinmentDTO;

@RestController
@RequestMapping("/api/appoinment")
public class AppoinmentController {
	@Autowired
	private AppoinmentService appoinmentService;
	@PostMapping("/book")
	public ResponseEntity<ApiResponse> bookAppoinment(@RequestBody AppoinmentDTO appoinmentDTO) {
		if(!SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
					new ApiResponse("User is not authenticated", false)
					);
		appoinmentService.bookAppointment(appoinmentDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				new ApiResponse("Appoinment booked", true)
				);
	}
	@GetMapping("/user")
	public ResponseEntity getUserAppoinments() {
		if(!SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
					new ApiResponse("User is not authenticated", false)
					);
		List<Appoinment> result=appoinmentService.userAppoinments();
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
}
