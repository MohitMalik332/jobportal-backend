package com.mohit.jobportal.service;

import java.util.List;

import com.mohit.jobportal.entity.Job;

public interface JobService {

	Job createJob(Job job, String email);
	
	List<Job> getAllJobs();
	
	List<Job> getJobsByRecruiter(String email);
}
