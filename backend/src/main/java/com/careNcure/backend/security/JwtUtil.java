package com.careNcure.backend.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	private static final String SECRET = "mySuperSecretKeyThatIsLongEnoughForCarenCureSecurity";
	private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

	private final long ACCESS_TOKEN_EXPIRATION = 1000 * 60 * 60; // 1 hour
	private final long REFRESH_TOKEN_EXPIRATION = 1000 * 60 * 60 * 24 * 7; // 7 days

	// ===== Access Token =====
	public String generateAccessToken(String username) {
		return Jwts.builder().subject(username) // replaces setSubject
				.issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION))
				.signWith(key) // algorithm auto-detected from key
				.compact();
	}

	// ===== Refresh Token =====
	public String generateRefreshToken(String username) {
		return Jwts.builder().subject(username).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION)).signWith(key).compact();
	}

	// ===== Common =====
	public String extractUsername(String token) {
		return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Date exp = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getExpiration();
			return exp.after(new Date());
		} catch (Exception e) {
			return false;
		}
	}
}
