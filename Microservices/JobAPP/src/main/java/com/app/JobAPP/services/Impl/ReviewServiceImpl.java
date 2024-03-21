package com.app.JobAPP.services.Impl;

import com.app.JobAPP.dto.ReviewDto;
import com.app.JobAPP.entities.Company;
import com.app.JobAPP.entities.Job;
import com.app.JobAPP.entities.Review;
import com.app.JobAPP.repositories.CompanyRepository;
import com.app.JobAPP.repositories.ReviewRepository;
import com.app.JobAPP.services.CompanyService;
import com.app.JobAPP.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    CompanyService companyService;
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Review> getAllReviews(int companyId) {
        return reviewRepository.findByCompanyCompId(companyId);
    }

    @Override
    public boolean addReview(ReviewDto reviewDto) {
        Company company = companyService.getCompanyById(reviewDto.getCompanyId());
        if (company != null) {
            Review review = Review.builder()
                    .title(reviewDto.getTitle())
                    .description(reviewDto.getDescription())
                    .rating(reviewDto.getRating())
                    .company(company)
                    .build();

            company.getReviews().add(review);
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(int reviewId) {
//        List<Review> reviews = reviewRepository.findByCompanyCompId();
//        return reviews.stream()
//                .filter(review -> review.getReviewId().equals(reviewId))
//                .findFirst()
//                .orElse(null);
       return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReview(int reviewId, Review updatedReview) {
        Optional<Review> existingReviewOptional = reviewRepository.findById(reviewId);
        if (existingReviewOptional.isPresent()) {
            Review review = existingReviewOptional.get();
            Company company = review.getCompany();

            if (updatedReview.getTitle() != null)
                review.setTitle(updatedReview.getTitle());
            if (updatedReview.getDescription() != null)
                review.setDescription(updatedReview.getDescription());
            if (updatedReview.getCompany() != null)
                review.setCompany(updatedReview.getCompany());
            if (updatedReview.getRating() != null)
                review.setRating(updatedReview.getRating());

            companyRepository.save(company);

            return true;
        }


        return false;
    }

    @Override
    public boolean deleteReview(int reviewId) {
        try {
            Optional<Review> reviewOptional = reviewRepository.findById(reviewId);
            if (reviewOptional.isPresent()) {
                Review review = reviewOptional.get();
                Company company = review.getCompany();
                if (company != null) {
                    company.getReviews().remove(review);
                    companyRepository.save(company);
                }
                reviewRepository.deleteById(reviewId);
                return true;
            }
            return false;

        } catch (Exception e) {
            return false;
        }

    }
}
