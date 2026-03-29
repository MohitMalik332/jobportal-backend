package com.mohit.jobportal.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.mohit.jobportal.entity.Job;
import com.mohit.jobportal.entity.User;
import com.mohit.jobportal.repository.JobRepository;
import com.mohit.jobportal.repository.UserRepository;
import com.mohit.jobportal.service.JobService;


@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Job createJob(Job job, String email) {
		// Get logged-in user from DB
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("User not Found..."));
		
		job.setUser(user);
		
		return jobRepository.save(job);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
