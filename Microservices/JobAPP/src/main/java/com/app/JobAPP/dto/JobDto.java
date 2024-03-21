package com.app.JobAPP.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDto {
    private String title;
    private String description;
    private Integer minSalary;
    private Integer maxSalary;
    private String location;
    private Integer companyId;
}
