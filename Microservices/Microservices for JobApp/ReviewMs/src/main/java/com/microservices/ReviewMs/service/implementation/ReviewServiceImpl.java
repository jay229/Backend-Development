package com.microservices.ReviewMs.service.implementation;

import com.microservices.ReviewMs.dto.ReviewWithCompanyDto;
import com.microservices.ReviewMs.external.Company;
import com.microservices.ReviewMs.mapper.ObjectMapper;
import com.microservices.ReviewMs.model.Review;
import com.microservices.ReviewMs.repository.ReviewRepository;
import com.microservices.ReviewMs.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<ReviewWithCompanyDto> getAllReviews(Integer companyId) {
      List<Review> reviews= reviewRepository.findByCompId(companyId);
        List<ReviewWithCompanyDto> reviewWithCompanyDtos = new ArrayList<>();
        for (Review review : reviews) {
            reviewWithCompanyDtos.add(getObjects(review));
        }
        return reviewWithCompanyDtos;

    }
    public ReviewWithCompanyDto getObjects(Review review) {
        String url = "http://COMPANY-SERVICE:8080/company/find/" + review.getCompId();
        Company company = restTemplate.getForObject(url, Company.class);
        return ObjectMapper.mapper(review, company);
    }

    @Override
    public boolean addReview(Review review) {
        reviewRepository.save(review);
        return true;
    }

    @Override
    public ReviewWithCompanyDto getReview(Integer reviewId) {
        Review review =reviewRepository.findById(reviewId).orElse(null);
        if (review!=null){
            return getObjects(review);
        }

        return null;

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
