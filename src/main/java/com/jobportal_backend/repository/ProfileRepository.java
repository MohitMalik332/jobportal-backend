package com.jobportal_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal_backend.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{
	
	// 1. Find profile by user (used when candidate logs in)
	Optional<Profile> findByUserId(Long userId);
	
}
