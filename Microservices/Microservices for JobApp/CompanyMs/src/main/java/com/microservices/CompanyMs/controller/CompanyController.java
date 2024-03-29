package com.microservices.CompanyMs.controller;

import com.microservices.CompanyMs.dto.CompanyWithReviewsDto;
import com.microservices.CompanyMs.model.Company;
import com.microservices.CompanyMs.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/find-all")
    public ResponseEntity<List<CompanyWithReviewsDto>> getAllCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(),
                HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable int id,
                                                @RequestBody Company company) {
        if (companyService.updateCompany(company, id)) {
            return new ResponseEntity<>("Company updated successfully",
                    HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not updated ",
                HttpStatus.NOT_MODIFIED);

    }

    @PostMapping("/save")
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added successfully",
                HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable int id) {
        boolean isDeleted = companyService.deleteCompanyById(id);
        if (isDeleted) {
            return new ResponseEntity<>("Company Successfully Deleted",
                    HttpStatus.OK);
        }
        return new ResponseEntity<>("Company Not Found",
                HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity getCompany(@PathVariable int id) {
        CompanyWithReviewsDto companyWithReviewsDto = companyService.getCompanyById(id);
        if (companyWithReviewsDto != null) {
            return new ResponseEntity<>(companyWithReviewsDto, HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not found with company id " + id, HttpStatus.NOT_FOUND);
    }
}
