package com.app.JobAPP.controllers;

import com.app.JobAPP.entities.Company;
import com.app.JobAPP.services.CompanyService;
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
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(),
                HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable int id,
                                                @RequestBody Company company){
        if (companyService.updateCompany(company, id)){
            return new ResponseEntity<>("Company updated successfully",
                    HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not updated ",
                HttpStatus.NOT_MODIFIED);

    }
    @PostMapping("/save")
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added successfully",
                HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable int id){
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
        Company company = companyService.getCompanyById(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>("Company not found with company id"+id,HttpStatus.NOT_FOUND);
    }


}
