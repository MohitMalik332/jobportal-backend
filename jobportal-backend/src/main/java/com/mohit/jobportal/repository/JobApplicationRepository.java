package com.mohit.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.jobportal.entity.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>{
	
//	To Check and prevent duplicate job applications.
	boolean existsByUserIdAndJobId(Long userId, Long jobId);
	
	List<JobApplication> findByJobId(Long jobId);
	
	List<JobApplication> findByUserId(Long userId);

}
