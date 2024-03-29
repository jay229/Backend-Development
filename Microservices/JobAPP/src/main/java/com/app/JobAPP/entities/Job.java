package com.app.JobAPP.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;
    private String title;
    private String description;
    private Integer minSalary;
    private Integer maxSalary;
    private String location;
    @ManyToOne
    private Company company;
}
