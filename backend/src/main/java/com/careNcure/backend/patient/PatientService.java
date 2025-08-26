package com.careNcure.backend.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careNcure.backend.authentication.UserCredentials;
import com.careNcure.backend.authentication.UserRepo;
import com.careNcure.backend.enums.Role;
import com.careNcure.backend.exception.DataAlreadyExistsException;
import com.careNcure.backend.payLoads.registrationDto.PatientRegistrationDTO;

@Service
public class PatientService {

	@Autowired
	private UserRepo userRepo;
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
		patientRepo.save(patient);
		UserCredentials userCredentials=new UserCredentials();
		userCredentials.setEmail(patientRegistrationDTO.getEmail());
		userCredentials.setMobile(patientRegistrationDTO.getMobile());
		userCredentials.setPassword(patientRegistrationDTO.getPassword());
		userCredentials.setRole(Role.Patient);
		userRepo.save(userCredentials);
	}

}
