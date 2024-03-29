package com.microservices.ReviewMs.controller;

import com.microservices.ReviewMs.dto.ReviewWithCompanyDto;
import com.microservices.ReviewMs.model.Review;
import com.microservices.ReviewMs.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping("/all/{companyId}")
    public ResponseEntity<List<ReviewWithCompanyDto>> getAllReviews(@PathVariable int companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId),
                HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> addReview(@RequestBody Review review){
        boolean isReviewSaved = reviewService.addReview(review);
        if (isReviewSaved)
            return new ResponseEntity<>("Review Added Successfully",
                    HttpStatus.OK);
        else
            return new ResponseEntity<>("Review Not Saved",
                    HttpStatus.NOT_FOUND);
    }
    @GetMapping("/find/{reviewId}")
    public ResponseEntity<ReviewWithCompanyDto> getReview(@PathVariable int reviewId){
        return new ResponseEntity<>(reviewService.getReview(reviewId),
                HttpStatus.OK);

    }
    @PutMapping("/update/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable int reviewId,@RequestBody Review review){
        boolean isReviewUpdated = reviewService.updateReview(reviewId, review);
        if (isReviewUpdated)
            return new ResponseEntity<>("Review updated successfully",
                    HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not updated",
                    HttpStatus.NOT_FOUND);


    }
    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable int reviewId){
        boolean isReviewDeleted = reviewService.deleteReview(reviewId);
        if (isReviewDeleted)
            return new ResponseEntity<>("Review deleted successfully",
                    HttpStatus.OK);
        else
            return new ResponseEntity<>("Review not deleted",
                    HttpStatus.NOT_FOUND);
    }
}
