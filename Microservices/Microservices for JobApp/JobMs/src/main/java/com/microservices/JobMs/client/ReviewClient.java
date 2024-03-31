package com.microservices.JobMs.client;

import com.microservices.JobMs.external.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "REVIEW-SERVICE")
public interface ReviewClient {
    @GetMapping("/company/review/all/{id}")
    List<Review> getReviews(@PathVariable("id") int id);
}
