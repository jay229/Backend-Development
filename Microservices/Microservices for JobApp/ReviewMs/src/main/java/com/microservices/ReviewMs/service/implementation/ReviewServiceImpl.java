package com.microservices.ReviewMs.service.implementation;

import com.microservices.ReviewMs.model.Review;
import com.microservices.ReviewMs.repository.ReviewRepository;
import com.microservices.ReviewMs.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews(Integer companyId) {
        if (companyId == null) {
            return null;
        }
        return reviewRepository.findByCompId(companyId);
    }

    @Override
    public boolean addReview(Review review) {
        reviewRepository.save(review);
        return true;
    }

    @Override
    public Review getReview(Integer reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(Integer reviewId, Review updatedReview) {
        Optional<Review> existingReviewOptional = reviewRepository.findById(reviewId);
        if (existingReviewOptional.isPresent()) {
            Review review = existingReviewOptional.get();

            if (updatedReview.getTitle() != null)
                review.setTitle(updatedReview.getTitle());
            if (updatedReview.getDescription() != null)
                review.setDescription(updatedReview.getDescription());
            if (updatedReview.getCompId() != null)
                review.setCompId(updatedReview.getCompId());
            if (updatedReview.getRating() != null)
                review.setRating(updatedReview.getRating());

            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Integer reviewId) {
       Review review=reviewRepository.findById(reviewId).orElse(null);
       if (review!=null){
           reviewRepository.delete(review);
           return true;
       }
       return false;

    }
}
