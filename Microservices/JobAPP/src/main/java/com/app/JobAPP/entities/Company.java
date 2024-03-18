package com.app.JobAPP;

import com.app.JobAPP.entities.Job;
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
    private Long compId;
    private String name;
    private String description;
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Job> jobs=new ArrayList<>();



}
