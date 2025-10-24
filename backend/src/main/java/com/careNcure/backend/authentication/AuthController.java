package com.careNcure.backend.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.careNcure.backend.payLoads.LoginDTO;
import com.careNcure.backend.security.JWTService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTService jwtService;
	@Autowired
	private UserService userService;

	// --- 1️⃣ Login ---
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
		if(loginDTO.getLogin()==null)
			throw new NullPointerException("Email or mobile can not be empty");
		else if(loginDTO.getPassword()==null)
			throw new NullPointerException("Password cannot be empty");
		Map<String, String> response= new HashMap<String, String>();
		Authentication auth = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getLogin(), loginDTO.getPassword()));
		String accessToken = jwtService.generateAccessToken(loginDTO.getLogin());
		String refreshToken =jwtService.generateRefreshToken(loginDTO.getLogin());
		response.put("AccessToken", accessToken);
		response.put("RefreshToken", refreshToken);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	
//    @PostMapping("/refresh")
//    public Map<String, String> refreshToken(@RequestHeader("Authorization") String refreshTokenHeader) {
//        if (refreshTokenHeader == null || !refreshTokenHeader.startsWith("Bearer ")) {
//            throw new IllegalArgumentException("Invalid token header");
//        }
//
//        String refreshToken = refreshTokenHeader.substring(7);
//
//        if (!jwtUtil.validateToken(refreshToken)) {
//            throw new RuntimeException("Invalid or expired refresh token");
//        }
//
//        String username = jwtUtil.extractUsername(refreshToken);
//        String role = jwtUtil.extractRole(refreshToken); // optional: or fetch from DB
//
//        String newAccessToken = jwtUtil.generateAccessToken(username, role);
//
//        return Map.of("accessToken", newAccessToken);
//    }

	// --- 3️⃣ Logout ---
	@PostMapping("/logout")
	public Map<String, String> logout(@RequestHeader("Authorization") String tokenHeader) {
		// Stateless JWT – optional blacklist can be implemented
		return Map.of("message", "Logged out successfully");
	}
}
