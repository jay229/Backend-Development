package com.microservices.JobMs.service.Implementation;


import com.microservices.JobMs.model.Job;
import com.microservices.JobMs.repository.JobRepository;
import com.microservices.JobMs.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> findAll(int companyId) {
        return jobRepository.findByCompId(companyId);
    }

    @Override
    public boolean createJob(Job job) {

        Job savedJob = Job.builder()
                .title(job.getTitle())
                .description(job.getDescription())
                .location(job.getLocation())
                .maxSalary(job.getMaxSalary())
                .minSalary(job.getMinSalary())
                .compId(job.getCompId())
                .build();
        if(jobRepository.save(savedJob)!=null){
            return true;
        }
        return false;
    }

    @Override
    public Job getJobById(int id) {
       return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(int id) {
       Job job=getJobById(id);
       if (job!=null){
           jobRepository.delete(job);
           return true;
       }
       return false;
    }

    @Override
    public boolean updateJob(int id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            if (updatedJob.getTitle()!=null)
                job.setTitle(updatedJob.getTitle());
            if (updatedJob.getDescription()!=null)
                job.setDescription(updatedJob.getDescription());
            if (updatedJob.getMinSalary()!=null)
                job.setMinSalary(updatedJob.getMinSalary());
            if (updatedJob.getMaxSalary()!=null)
                job.setMaxSalary(updatedJob.getMaxSalary());
            if (updatedJob.getLocation()!=null)
                job.setLocation(updatedJob.getLocation());
            if (updatedJob.getCompId()!=null){
                job.setCompId(updatedJob.getCompId());
            }

            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
