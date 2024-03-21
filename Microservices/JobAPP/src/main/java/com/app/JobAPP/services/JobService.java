package com.app.JobAPP.services;

import com.app.JobAPP.dto.JobDto;
import com.app.JobAPP.entities.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll(int companyId);
    boolean createJob(JobDto job);
    Job getJobById(int id);
    boolean deleteJobById(int id);
    boolean updateJob(int id, Job updatedJob);
}
