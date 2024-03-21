package com.app.JobAPP.services.Impl;

import com.app.JobAPP.dto.JobDto;
import com.app.JobAPP.entities.Company;
import com.app.JobAPP.entities.Job;
import com.app.JobAPP.repositories.CompanyRepository;
import com.app.JobAPP.repositories.JobRepository;
import com.app.JobAPP.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    CompanyRepository companyRepository;


    @Override
    public List<Job> findAll(int companyId) {
        Optional<Company> companyOptional=companyRepository.findById(companyId);
        List<Job> jobs=new ArrayList<>();
        if (companyOptional.isPresent()){
            Company company=companyOptional.get();
            jobs=company.getJobs();
        }
        return jobs;


    }

    @Override
    public boolean createJob(JobDto jobDto){
        Optional<Company> companyOptional=companyRepository.findById(jobDto.getCompanyId());
        if (companyOptional.isPresent()){
            Company company=companyOptional.get();
            Job job = Job.builder()
                    .title(jobDto.getTitle())
                    .description(jobDto.getDescription())
                    .location(jobDto.getLocation())
                    .maxSalary(jobDto.getMaxSalary())
                    .minSalary(jobDto.getMinSalary())
                    .company(company)
                    .build();

            company.getJobs().add(job);
            companyRepository.save(company);

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
        try {
            Optional<Job> jobOptional = jobRepository.findById(id);
            if (jobOptional.isPresent()) {
                Job job = jobOptional.get();
                Company company = job.getCompany();
                if (company != null) {
                    company.getJobs().remove(job); // Remove the job from the company's list of jobs
                    companyRepository.save(company);
                }
                jobRepository.deleteById(id);


                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
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

            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
