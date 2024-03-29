package com.microservices.JobMs.controller;

import com.microservices.JobMs.dto.JobWithCompanyDto;
import com.microservices.JobMs.external.Company;
import com.microservices.JobMs.model.Job;
import com.microservices.JobMs.service.Implementation.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobServiceImpl jobService;

    @GetMapping("/find-all/{companyId}")
    public ResponseEntity<List<JobWithCompanyDto>> findAll(@PathVariable int companyId) {
        return ResponseEntity.ok(jobService.findAll(companyId));
    }

    @PostMapping("/save")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        if (jobService.createJob(job))
            return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
        return new ResponseEntity<>("Job not created ", HttpStatus.NOT_ACCEPTABLE);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<JobWithCompanyDto> getJobById(@PathVariable int id) {
        JobWithCompanyDto jobWithCompanyDto = jobService.getJobById(id);
        if (jobWithCompanyDto != null)
            return new ResponseEntity<>(jobWithCompanyDto, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id) {
        boolean deleted = jobService.deleteJobById(id);
        if (deleted)
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateJob(@PathVariable int id,
                                            @RequestBody Job updatedJob) {
        boolean updated = jobService.updateJob(id, updatedJob);
        if (updated)
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
