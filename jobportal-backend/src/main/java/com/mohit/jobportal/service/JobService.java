package com.mohit.jobportal.service;

import com.mohit.jobportal.entity.Job;

public interface JobService {

	Job createJob(Job job, String email);
}
