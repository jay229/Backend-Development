package com.microservices.JobMs.mapper;

import com.microservices.JobMs.dto.JobWithCompanyDto;
import com.microservices.JobMs.external.Company;
import com.microservices.JobMs.external.Review;
import com.microservices.JobMs.model.Job;

import java.util.List;

public class ObjectMapper {
    public static JobWithCompanyDto mapper(Job job, Company  company, List<Review> reviews){
        return JobWithCompanyDto.builder()
                .jobId(job.getJobId())
                .title(job.getTitle())
                .description(job.getDescription())
                .location(job.getLocation())
                .minSalary(job.getMinSalary())
                .maxSalary(job.getMaxSalary())
                .company(company)
                .reviews(reviews)
                .build();

    }
}
