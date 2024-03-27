package com.microservices.ReviewMs.service;


import com.microservices.ReviewMs.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Integer companyId);
    boolean addReview(Review review);
    Review getReview(Integer reviewId);
    boolean updateReview(Integer reviewId, Review review);
    boolean deleteReview(Integer reviewId);
}
