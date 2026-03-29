package com.mohit.jobportal.config;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private JwtUtil jwtUtil;
	
	public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println("JWT FILTER CALLED");
		
		String authHeader = request.getHeader("Authorization");
		System.out.println("AUTH HEADER: " + authHeader);
		
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			
			String token = authHeader.substring(7);
			System.out.println("TOKEN: " + token);
			
			try {
				String email = jwtUtil.extractEmail(token);
				System.out.println("EMAIL FROM TOKEN: " + email);
				
				boolean isValid = jwtUtil.validateToken(token);
			    System.out.println("IS TOKEN VALID: " + isValid);
				
				if (email != null && isValid) {
					
					String role = jwtUtil.extractRole(token);
					System.out.println("ROLE FROM TOKEN: " + role);
					
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
								email, 
								null, 
								List.of(new SimpleGrantedAuthority(role))
								
							);
					
					
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
				
			} catch (Exception e) {
				System.out.println("Invalid JWT Token");
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
