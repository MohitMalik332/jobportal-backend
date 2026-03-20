package com.mohit.jobportal.service;

import com.mohit.jobportal.dto.LoginRequestDTO;
import com.mohit.jobportal.dto.RegisterRequestDTO;
import com.mohit.jobportal.dto.UserResponseDTO;

public interface UserService {
	
	UserResponseDTO registerUser(RegisterRequestDTO request);
	
	String loginUser(LoginRequestDTO request);
}
