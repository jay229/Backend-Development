package com.microservices.JobMs.service;


import com.microservices.JobMs.model.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll(int companyId);
    boolean createJob(Job job);
    Job getJobById(int id);
    boolean deleteJobById(int id);
    boolean updateJob(int id, Job updatedJob);
}
