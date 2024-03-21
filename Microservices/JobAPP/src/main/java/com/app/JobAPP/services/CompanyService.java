package com.app.JobAPP.services;


import com.app.JobAPP.entities.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company, int id);
    void createCompany(Company company);
    boolean deleteCompanyById(int id);
    Company getCompanyById(int id);
}
