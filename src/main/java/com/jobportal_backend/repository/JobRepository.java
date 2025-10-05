package com.jobportal_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal_backend.entity.Job;


public interface JobRepository extends JpaRepository<Job, Long>{

	// 1. Find jobs by location (used in job search/filter)
	List<Job> findByLocation(String location);
	
	// 2. Find jobs by required skill (used in job search/filter)
	List<Job> findBySkillRequiredContaining(String skill);
	
	// 3. Find jobs by experience required (used in job search/filter)
	List<Job> findByExperienceRequiredLessThanEqual(int experience);
	
	// 4. Find jobs posted by a specific employer (used in employer dashboard)
	List<Job> findByEmployerId(Long id);
}
