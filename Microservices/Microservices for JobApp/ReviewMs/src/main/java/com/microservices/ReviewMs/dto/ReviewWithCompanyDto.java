package com.microservices.ReviewMs.dto;

import com.microservices.ReviewMs.external.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewWithCompanyDto {
    private Integer reviewId;
    private String title;
    private String description;
    private Double rating;
    private Company company;
}
