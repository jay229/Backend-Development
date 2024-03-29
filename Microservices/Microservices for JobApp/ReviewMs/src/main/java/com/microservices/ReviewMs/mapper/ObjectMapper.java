package com.microservices.ReviewMs.mapper;

import com.microservices.ReviewMs.dto.ReviewWithCompanyDto;
import com.microservices.ReviewMs.external.Company;
import com.microservices.ReviewMs.model.Review;

public class ObjectMapper {
    public static ReviewWithCompanyDto mapper(Review review, Company company){
        return ReviewWithCompanyDto.builder()
                .reviewId(review.getReviewId())
                .title(review.getTitle())
                .description(review.getDescription())
                .rating(review.getRating())
                .company(company)
                .build();
    }
}
