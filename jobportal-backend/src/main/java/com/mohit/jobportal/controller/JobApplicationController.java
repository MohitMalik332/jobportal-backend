package com.mohit.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.jobportal.entity.JobApplication;
import com.mohit.jobportal.service.JobApplicationService;

@RestController
@RequestMapping("/applications")
public class JobApplicationController {
	
	@Autowired
	private JobApplicationService applicationService;

	@PostMapping("/apply/{jobId}")
	public String apply(@PathVariable Long jobId) {
		return applicationService.applyForJob(jobId);
	}
	
	@GetMapping("/job/{jobId}")
	public List<JobApplication> getApplications(@PathVariable Long jobId){
		return applicationService.getApplicationsByJob(jobId);
	}
	
	@GetMapping("/my")
	public List<JobApplication> getMyApplications() {
		return applicationService.getMyApplications();
	}
}
