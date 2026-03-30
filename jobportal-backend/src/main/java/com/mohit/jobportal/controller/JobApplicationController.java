package com.mohit.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
