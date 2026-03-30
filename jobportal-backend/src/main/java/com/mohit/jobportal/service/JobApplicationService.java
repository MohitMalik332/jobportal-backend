package com.mohit.jobportal.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.mohit.jobportal.entity.Job;
import com.mohit.jobportal.entity.JobApplication;
import com.mohit.jobportal.entity.User;
import com.mohit.jobportal.repository.JobApplicationRepository;
import com.mohit.jobportal.repository.JobRepository;
import com.mohit.jobportal.repository.UserRepository;

@Service
public class JobApplicationService {

	@Autowired
	private JobApplicationRepository applicationRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public String applyForJob(Long jobId) {
		
		// 1. Get logged-in user email
		String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("User Not Found..."));
		
		// 2. Get job
		Job job = jobRepository.findById(jobId)
				.orElseThrow(() -> new RuntimeException("Job not Found..."));
		
		// 3. Check Duplicate
		boolean alreadyApplied = applicationRepository.existsByUserIdAndJobId(user.getId(), jobId);
		
		if (alreadyApplied) {
			return "You have already applied to this job";
		}
		
		// 4. Save application
		JobApplication application = new JobApplication();
		application.setUser(user);
        application.setJob(job);
        application.setAppliedDate(LocalDateTime.now());

        applicationRepository.save(application);

        return "Job applied successfully";
	}
	
}
