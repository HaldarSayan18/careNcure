package com.careNcure.backend.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careNcure.backend.enums.Role;
import com.careNcure.backend.exception.DataAlreadyExistsException;
import com.careNcure.backend.payLoads.UserDTO;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	public void addUser(UserDTO userDTO) {
		if(userDTO.getMobile()<1000000000l || userDTO.getMobile()>9999999999l)
			throw new IllegalArgumentException("Not a valid mobile number");
		else if(userDTO.getPassword().length()<8)
			throw new IllegalArgumentException("Weak password");
		else if(userRepo.findByEmail(userDTO.getEmail())!=null)
			throw new DataAlreadyExistsException("Email id already registered.");
		else if(userRepo.findByMobile(userDTO.getMobile())!=null)
			throw new DataAlreadyExistsException("Mobile number already registered.");
		UserCredentials userCredentials=new UserCredentials();
		userCredentials.setEmail(userDTO.getEmail());
		userCredentials.setMobile(userDTO.getMobile());
		userCredentials.setPassword(userDTO.getPassword());
		userCredentials.setRole(Role.valueOf(userDTO.getRole()));
		userRepo.save(userCredentials);
	}
}
