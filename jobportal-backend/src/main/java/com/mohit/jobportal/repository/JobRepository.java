package com.mohit.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.jobportal.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

	// This gives us many important methods
	// save(job), findAll(), findById(), deleteById() etc
}
