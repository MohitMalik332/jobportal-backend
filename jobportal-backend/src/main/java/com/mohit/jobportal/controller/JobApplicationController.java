package com.mohit.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.jobportal.entity.JobApplication;
import com.mohit.jobportal.repository.JobApplicationRepository;
import com.mohit.jobportal.service.JobApplicationService;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {
	
	@Autowired
	private JobApplicationService applicationService;
	
	@Autowired
    private JobApplicationRepository repo;
	

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
	
	@PutMapping("/accept/{id}")
	public String accept(@PathVariable Long id) {
	    JobApplication app = repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Application not found"));

	    app.setStatus("ACCEPTED");
	    repo.save(app);

	    return "Accepted";
	}
	
	
	@PutMapping("/reject/{id}")
	public String reject(@PathVariable Long id) {
	    JobApplication app = repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Application not found"));

	    app.setStatus("REJECTED");
	    repo.save(app);

	    return "Rejected";
	}
}
