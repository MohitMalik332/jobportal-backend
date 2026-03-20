package com.mohit.jobportal.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private final String SECRET = "mysecretkeymysecretkeymysecretkey12345";
	
	private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());
	
	// Generate Token
	public String generateToken(String email) {
		
		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))   // 1 hour
				.signWith(key)
				.compact();
	}
}
