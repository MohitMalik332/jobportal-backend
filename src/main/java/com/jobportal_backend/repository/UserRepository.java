package com.jobportal_backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobportal_backend.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	// 1. Find user by email (it will be used during login)
	Optional<User> findByEmail(String email);
	
	// 2. Check if email already exists (It will prevent duplicates sign ups)
	boolean existsByEmail(String email);
	
	// 3. Find all users by role (useful when the ADMIN listing all candidates or employers)
	List<User> findAllByRole(String role);
}
