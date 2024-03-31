package com.microservices.JobMs.service.Implementation;


import com.microservices.JobMs.client.CompanyClient;
import com.microservices.JobMs.client.ReviewClient;
import com.microservices.JobMs.dto.JobWithCompanyDto;
import com.microservices.JobMs.external.Company;
import com.microservices.JobMs.external.Review;
import com.microservices.JobMs.mapper.ObjectMapper;
import com.microservices.JobMs.model.Job;
import com.microservices.JobMs.repository.JobRepository;
import com.microservices.JobMs.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
//@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    RestTemplate restTemplate;

    private final CompanyClient companyClient;
    private final ReviewClient reviewClient;

    public JobServiceImpl(CompanyClient companyClient, ReviewClient reviewClient) {
        this.companyClient = companyClient;
        this.reviewClient = reviewClient;
    }

    @Override
    public List<JobWithCompanyDto> findAll(int companyId) {
        List<Job> jobs = jobRepository.findByCompId(companyId);
        List<JobWithCompanyDto> jobWithCompanyDtos = new ArrayList<>();
//        RestTemplate restTemplate=new RestTemplate();
        for (Job job : jobs) {
            jobWithCompanyDtos.add(getObjects(job));
        }
        return jobWithCompanyDtos;


    }

    public JobWithCompanyDto getObjects(Job job) {

//        Using RestTemplate
//        String url = "http://COMPANY-SERVICE:8080/company/find/" + job.getCompId();
//        String review_url = "http://REVIEW-SERVICE:8082/company/review/all/" + job.getCompId();

        RestTemplate template = new RestTemplate();
        Company company = template.getForObject("http://localhost:8080/company/find/" + job.getCompId(), Company.class);

        ResponseEntity<List<Review>> response = template.exchange(
                "http://localhost:8082/company/review/all/" + job.getCompId(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Review>>() {
                });
        List<Review> reviews = response.getBody();

//        Using Feign
//        Company company=companyClient.getCompany(job.getCompId());
//        System.out.println("Company Id :"+company.getCompId());
//        System.out.println("Company name :"+company.getName());
//        List<Review> reviews=reviewClient.getReviews(job.getCompId());

        return ObjectMapper.mapper(job, company, reviews);
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
        if (jobRepository.save(savedJob) != null) {
            return true;
        }
        return false;
    }

    @Override
    public JobWithCompanyDto getJobById(int id) {
        Job job = jobRepository.findById(id).orElse(null);
        System.out.println("Job id:" + job.getJobId());
        System.out.println("Job title:" + job.getTitle());
        if (job != null) {
            return getObjects(job);
        }
        return null;
    }

    @Override
    public boolean deleteJobById(int id) {
        Job job = jobRepository.findById(id).orElse(null);
        if (job != null) {
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
            if (updatedJob.getTitle() != null)
                job.setTitle(updatedJob.getTitle());
            if (updatedJob.getDescription() != null)
                job.setDescription(updatedJob.getDescription());
            if (updatedJob.getMinSalary() != null)
                job.setMinSalary(updatedJob.getMinSalary());
            if (updatedJob.getMaxSalary() != null)
                job.setMaxSalary(updatedJob.getMaxSalary());
            if (updatedJob.getLocation() != null)
                job.setLocation(updatedJob.getLocation());
            if (updatedJob.getCompId() != null) {
                job.setCompId(updatedJob.getCompId());
            }

            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
