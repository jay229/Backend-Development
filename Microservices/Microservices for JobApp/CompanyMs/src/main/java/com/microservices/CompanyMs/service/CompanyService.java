package com.microservices.CompanyMs.service;

import com.microservices.CompanyMs.dto.CompanyWithReviewsDto;
import com.microservices.CompanyMs.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CompanyService {
    List<CompanyWithReviewsDto> getAllCompanies();

    boolean updateCompany(Company company, int id);

    void createCompany(Company company);

    boolean deleteCompanyById(int id);

    CompanyWithReviewsDto getCompanyById(int id);
}
