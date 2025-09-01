package com.careNcure.backend.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTService {
	private static final String SECRET = "mySuperSecretKeyThatIsLongEnoughForCarenCureSecurity";
	private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

	private final long ACCESS_TOKEN_EXPIRATION = 1000 * 60 * 60; // 1 hour
	private final long REFRESH_TOKEN_EXPIRATION = 1000 * 60 * 60 * 24 * 7; // 7 days
	public String generateAccessToken(String userName) {
		Map<String, Object> claims=new HashMap<String, Object>();
		claims.put("Type", "Access");
		return Jwts.builder()
				.claims().add(claims)
				.subject(userName)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+ACCESS_TOKEN_EXPIRATION))
				.and()
				.signWith(key)
				.compact();
	}
	public String generateRefreshToken(String userName) {
		Map<String, Object> claims=new HashMap<String, Object>();
		claims.put("Type", "Refresh");
		return Jwts.builder()
				.claims().add(claims)
				.subject(userName)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+ACCESS_TOKEN_EXPIRATION))
				.and()
				.signWith(key)
				.compact();
	}
	public String extractUserName(String token) {
		return extractClaim(token,Claims::getSubject);
	}
	private <T> T extractClaim(String token,Function<Claims,T> claimResolver) {
		final Claims claims=extractAllClaims(token);
		return claimResolver.apply(claims);
	}
	private Claims extractAllClaims(String token) {
		return Jwts.parser().verifyWith(key)
				.build().parseSignedClaims(token).getPayload();
	}
	public boolean validateToken(String token, UserDetails userDetails) {
		final String userName=extractUserName(token);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	public String extractTokenType(String token) {
	    return extractClaim(token, claims -> claims.get("Type", String.class));
	}
}
