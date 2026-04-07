package com.mohit.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.jobportal.entity.Job;
import com.mohit.jobportal.service.JobService;


@RestController
@RequestMapping("/api/jobs")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	
	@PostMapping("/create")
	public Job createJob(@RequestBody Job job, Authentication authentication) {
		
		String email = authentication.getName();
		
		return jobService.createJob(job, email);
	}
	
	@GetMapping
	public List<Job> getAllJobs() {
		return jobService.getAllJobs();
	}
	
	@GetMapping("/recruiter/my")
	public List<Job> getMyJobs(Authentication authentication){
		String email = authentication.getName();
		
		return jobService.getJobsByRecruiter(email);
	}
}
