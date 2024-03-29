package com.microservices.JobMs.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    private Integer reviewId;
    private String title;
    private String description;
    private Double rating;
//    private Integer compId;
}
