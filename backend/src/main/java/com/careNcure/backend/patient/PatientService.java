package com.careNcure.backend.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.careNcure.backend.authentication.UserService;
import com.careNcure.backend.exception.DataAlreadyExistsException;
import com.careNcure.backend.payLoads.UserDTO;
import com.careNcure.backend.payLoads.registrationDto.PatientRegistrationDTO;

@Service
public class PatientService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	@Autowired
	private PatientRepo patientRepo;
	
	public void registerPatient(PatientRegistrationDTO patientRegistrationDTO) {
		if(patientRepo.findByMobile(patientRegistrationDTO.getMobile())!=null)
			throw new DataAlreadyExistsException("Patient already registered");
		else if(patientRepo.findByEmail(patientRegistrationDTO.getEmail())!=null)
			throw new DataAlreadyExistsException("Patient already registered");
		Patient patient=new Patient();
		patient.setFirstName(patientRegistrationDTO.getFirstName());
		patient.setLastName(patientRegistrationDTO.getLastName());
		patient.setEmail(patientRegistrationDTO.getEmail());
		patient.setMobile(patientRegistrationDTO.getMobile());
		patient.setAddress(patientRegistrationDTO.getAddress());
		patientRepo.save(patient);
		UserDTO userDTO=new UserDTO();
		userDTO.setEmail(patientRegistrationDTO.getEmail());
		userDTO.setMobile(patientRegistrationDTO.getMobile());
		userDTO.setPassword(passwordEncoder.encode(patientRegistrationDTO.getPassword()));
		userDTO.setRole("Patient");
		userService.addUser(userDTO);
	}

}
