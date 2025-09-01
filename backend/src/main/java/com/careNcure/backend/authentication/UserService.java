package com.careNcure.backend.authentication;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.careNcure.backend.enums.Role;
import com.careNcure.backend.exception.DataAlreadyExistsException;
import com.careNcure.backend.payLoads.UserDTO;
@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;
    private final BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    
	
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
		userCredentials.setPassword(encoder.encode(userDTO.getPassword()));
		userCredentials.setRole(Role.valueOf(userDTO.getRole()));
		userRepo.save(userCredentials);
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCredentials user;

	    if (username.matches("\\d+")) { // if only digits, treat as mobile
	        user = userRepo.findByMobile(Long.parseLong(username));
	    } else {
	        user = userRepo.findByEmail(username);
	    }

	    if (user == null) {
	        throw new UsernameNotFoundException("User not found with: " + username);
	    }
	    return new UserPrinciple(user);
	}
}
