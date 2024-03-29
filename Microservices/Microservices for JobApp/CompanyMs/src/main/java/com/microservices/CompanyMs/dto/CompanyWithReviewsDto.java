package com.microservices.CompanyMs.dto;

import com.microservices.CompanyMs.external.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyWithReviewsDto {
    private Integer compId;
    private String name;
    private String description;
    List<Review> reviews=new ArrayList<>();
}
