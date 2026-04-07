package com.mohit.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohit.jobportal.entity.Job;
import com.mohit.jobportal.entity.User;

public interface JobRepository extends JpaRepository<Job, Long>{

	// This gives us many important methods
	// save(job), findAll(), findById(), deleteById() etc
	
	List<Job> findByUser(User user);
}
