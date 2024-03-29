package com.microservices.JobMs.dto;

import com.microservices.JobMs.external.Company;
import com.microservices.JobMs.external.Review;
import com.microservices.JobMs.model.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobWithCompanyDto {
    private Integer jobId;
    private String title;
    private String description;
    private Integer minSalary;
    private Integer maxSalary;
    private String location;
    Company company;
    List<Review>reviews=new ArrayList<>();

}
