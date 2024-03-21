package com.app.JobAPP.services.Impl;

import com.app.JobAPP.entities.Company;
import com.app.JobAPP.repositories.CompanyRepository;
import com.app.JobAPP.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;



    @Override
    public List<Company> getAllCompanies() {
       return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, int id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company companyToUpdate = companyOptional.get();
            if (company.getName()!=null){
                companyToUpdate.setName(company.getName());
            }
            if (company.getDescription()!=null){
                companyToUpdate.setDescription(company.getDescription());
            }
            if (company.getJobs()!=null){
                companyToUpdate.setJobs(company.getJobs());
            }

            companyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(int id) {
       if (companyRepository.existsById(id)){
           companyRepository.deleteById(id);
           return true;
       }
       return false;
    }

    @Override
    public Company getCompanyById(int id) {
        return companyRepository.findById(id).orElse(null);
    }
}
