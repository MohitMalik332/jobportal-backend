package com.mohit.jobportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mohit.jobportal.config.JwtUtil;
import com.mohit.jobportal.dto.LoginRequestDTO;
import com.mohit.jobportal.dto.RegisterRequestDTO;
import com.mohit.jobportal.dto.UserResponseDTO;
import com.mohit.jobportal.entity.Role;
import com.mohit.jobportal.entity.User;
import com.mohit.jobportal.repository.RoleRepository;
import com.mohit.jobportal.repository.UserRepository;
import com.mohit.jobportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtUtil jwtUtil;
    

    @Override
    public UserResponseDTO registerUser(RegisterRequestDTO request) {

        // Fetch default role
        Role role = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // Create User Entity
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);

        // Save user
        User savedUser = userRepository.save(user);

        // Convert Entity → DTO
        UserResponseDTO response = new UserResponseDTO();
        response.setId(savedUser.getId());
        response.setFullName(savedUser.getFullName());
        response.setEmail(savedUser.getEmail());

        return response;
    }
    
    
    public String loginUser(LoginRequestDTO request) {
    	
    	User user = userRepository.findByEmail(request.getEmail())
    			.orElseThrow(() -> new RuntimeException("User Not Found"));
    	
    	// Check Password
    	if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
    		throw new RuntimeException("Invalid Password");
    	}
    	
    	// Generate JWT
    	return jwtUtil.generateToken(user.getEmail());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}