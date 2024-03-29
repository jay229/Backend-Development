package com.microservices.JobMs.service;


import com.microservices.JobMs.dto.JobWithCompanyDto;
import com.microservices.JobMs.model.Job;

import java.util.List;

public interface JobService {
    List<JobWithCompanyDto> findAll(int companyId);

    boolean createJob(Job job);

    JobWithCompanyDto getJobById(int id);

    boolean deleteJobById(int id);

    boolean updateJob(int id, Job updatedJob);
}
