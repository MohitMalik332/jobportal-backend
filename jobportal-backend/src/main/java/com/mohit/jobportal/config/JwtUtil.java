package com.mohit.jobportal.config;


import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private final String SECRET = "mysecretkeymysecretkeymysecretkey12345";
	
	private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());
	
	// Generate Token
	public String generateToken(String email, String role) {
		
		return Jwts.builder()
				.setSubject(email)
				.claim("role", role)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))   // 1 hour
				.signWith(key)
				.compact();
	}
	
	
	public String extractEmail(String token) {
		return extractClaims(token).getSubject();
	}
	
	public String extractRole(String token) {
		return extractClaims(token).get("role", String.class);
	}
	

	private Claims extractClaims(String token) {
		
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	
	public boolean validateToken(String token) {
		try {
			extractClaims(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
