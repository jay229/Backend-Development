package com.app.JobAPP.services;

import com.app.JobAPP.dto.ReviewDto;
import com.app.JobAPP.entities.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(int companyId);
    boolean addReview(ReviewDto reviewDto);
    Review getReview(int reviewId);
    boolean updateReview(int reviewId, Review review);
    boolean deleteReview(int reviewId);
}
