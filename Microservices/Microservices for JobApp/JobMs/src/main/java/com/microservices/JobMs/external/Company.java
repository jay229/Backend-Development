package com.microservices.JobMs.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    private Integer compId;
    private String name;
    private String description;
}
