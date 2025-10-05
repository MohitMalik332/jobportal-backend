package com.jobportal_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal_backend.entity.Application;


public interface ApplicationRepository extends JpaRepository<Application, Long>{
	
	// 1. Find all applications by candidate (for candidate dashboard)
	List<Application> findByCandidateId(Long candidateId);
	
	// 2. Find all applications for a specific job (for employer dashboard)
	List<Application> findByJobId(Long jobId);
	
	// 3. Find applications by status (useful for employer filtering)
	List<Application> findByStatus(String status);
}
