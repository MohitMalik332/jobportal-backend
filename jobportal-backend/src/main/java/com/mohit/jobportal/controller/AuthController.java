package com.mohit.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.jobportal.dto.LoginRequestDTO;
import com.mohit.jobportal.dto.RegisterRequestDTO;
import com.mohit.jobportal.dto.UserResponseDTO;
import com.mohit.jobportal.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public UserResponseDTO registerUser(@RequestBody RegisterRequestDTO request) {
		
		return userService.registerUser(request);
	}
	
	
	@PostMapping("/login")
	public String loginUser(@RequestBody LoginRequestDTO request) {
		return userService.loginUser(request);
	}
	
	
	@GetMapping("/test")
	public String test() {
	    return "JWT is working!";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
