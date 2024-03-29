package com.microservices.ReviewMs.service;


import com.microservices.ReviewMs.dto.ReviewWithCompanyDto;
import com.microservices.ReviewMs.model.Review;

import java.util.List;

public interface ReviewService {
    List<ReviewWithCompanyDto> getAllReviews(Integer companyId);
    boolean addReview(Review review);
    ReviewWithCompanyDto getReview(Integer reviewId);
    boolean updateReview(Integer reviewId, Review review);
    boolean deleteReview(Integer reviewId);
}
