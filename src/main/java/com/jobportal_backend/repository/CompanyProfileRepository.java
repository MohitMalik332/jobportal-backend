package com.jobportal_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal_backend.entity.CompanyProfile;

public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Long>{

	// 1. Find company profile by employer (User) ID
	Optional<CompanyProfile> findByUserId(Long userId);
	
}
