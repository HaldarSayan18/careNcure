package com.careNcure.backend.appoinment;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.careNcure.backend.authentication.UserCredentials;
import com.careNcure.backend.authentication.UserRepo;
import com.careNcure.backend.doctor.Doctor;
import com.careNcure.backend.doctor.DoctorRepo;
import com.careNcure.backend.hospital.Hospital;
import com.careNcure.backend.hospital.HospitalRepo;
import com.careNcure.backend.payLoads.AppoinmentDTO;
import com.careNcure.backend.speciality.Speciality;
import com.careNcure.backend.speciality.SpecialityRepo;

@Service
public class AppoinmentService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private SpecialityRepo specialityRepo;
	@Autowired
	private DoctorRepo doctorRepo;
	@Autowired
	private HospitalRepo hospitalRepo;
	@Autowired
	private AppoinmentRepo appoinmentRepo;

	public void bookAppointment(AppoinmentDTO appoinmentDTO) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();

		} else
			throw new AuthenticationCredentialsNotFoundException("User is not authenticated");
		UserCredentials user;
		if (username.contains("@"))
			user = userRepo.findByEmail(username);
		else
			user = userRepo.findByMobile(Long.parseLong(username));

		Speciality speciality = specialityRepo.findBySpecialityAndHospital_Id(
		        appoinmentDTO.getSpecialityName(),
		        appoinmentDTO.getHospitalId()
		).orElseThrow(() -> new RuntimeException("Speciality not found"));

		Doctor doctor = doctorRepo.findById(appoinmentDTO.getDoctorId())
				.orElseThrow(() -> new RuntimeException("Doctor not found"));

		Hospital hospital = hospitalRepo.findById(appoinmentDTO.getHospitalId())
				.orElseThrow(() -> new RuntimeException("Hospital not found"));

		Date date=Date.valueOf(appoinmentDTO.getDate());
		
		if(appoinmentRepo.findByBookedByAndDoctorAndDateAndPatientName(user.getId(), doctor, date,appoinmentDTO.getPatientName())!=null)
			throw new RuntimeException("Appoinment alredy exist with same patient name");

		// Create appointment entity
		Appoinment appoinment = new Appoinment(user.getId(), appoinmentDTO.getPatientName(), appoinmentDTO.getAge(),
				appoinmentDTO.getAddress(), appoinmentDTO.getMobileNo(), speciality, doctor, hospital, date,
				appoinmentDTO.getPurpose());

		// Save appointment
		appoinmentRepo.save(appoinment);
	}
	public List<Appoinment> userAppoinments(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();

		} else
			throw new AuthenticationCredentialsNotFoundException("User is not authenticated");
		UserCredentials user;
		if (username.contains("@"))
			user = userRepo.findByEmail(username);
		else
			user = userRepo.findByMobile(Long.parseLong(username));
		return appoinmentRepo.findByBookedBy(user.getId());
	}

}
