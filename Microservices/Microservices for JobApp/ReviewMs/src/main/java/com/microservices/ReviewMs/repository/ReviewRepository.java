package com.microservices.ReviewMs.repository;

import com.microservices.ReviewMs.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByCompId(int compId);
}
