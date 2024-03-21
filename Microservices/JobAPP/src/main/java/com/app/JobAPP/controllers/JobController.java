package com.app.JobAPP.controllers;

import com.app.JobAPP.dto.JobDto;
import com.app.JobAPP.entities.Job;
import com.app.JobAPP.services.Impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobServiceImpl jobService;

    @GetMapping("/find-all/{companyId}")
    public ResponseEntity<List<Job>> findAll(@PathVariable int companyId){
        return ResponseEntity.ok(jobService.findAll(companyId));
    }

    @PostMapping("/save")
    public ResponseEntity<String> createJob(@RequestBody JobDto jobDto) {
        if (jobService.createJob(jobDto))
            return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
        return new ResponseEntity<>("Job not created ", HttpStatus.NOT_ACCEPTABLE);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable int id){
        Job job = jobService.getJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable int id){
        boolean deleted = jobService.deleteJobById(id);
        if (deleted)
            return new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    //@RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable int id,
                                            @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id, updatedJob);
        if (updated)
            return new ResponseEntity<>("Job updated successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
