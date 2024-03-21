package com.app.JobAPP.entities;

import com.app.JobAPP.entities.Job;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer compId;
    private String name;
    private String description;
    @JsonIgnore
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Job> jobs=new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews=new ArrayList<>();




}
