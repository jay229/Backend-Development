package com.microservices.CompanyMs.mapper;

import com.microservices.CompanyMs.dto.CompanyWithReviewsDto;
import com.microservices.CompanyMs.external.Review;
import com.microservices.CompanyMs.model.Company;

import java.util.List;

public class ObjectMapper {
    public static CompanyWithReviewsDto mapper(Company company, List<Review> reviews){
        return CompanyWithReviewsDto.builder()
                .compId(company.getCompId())
                .name(company.getName())
                .description(company.getDescription())
                .reviews(reviews)
                .build();
    }
}
