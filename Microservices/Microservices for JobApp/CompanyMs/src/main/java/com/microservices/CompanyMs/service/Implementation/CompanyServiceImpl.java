package com.microservices.CompanyMs.service.Implementation;

import com.microservices.CompanyMs.dto.CompanyWithReviewsDto;
import com.microservices.CompanyMs.external.Review;
import com.microservices.CompanyMs.mapper.ObjectMapper;
import com.microservices.CompanyMs.model.Company;
import com.microservices.CompanyMs.repository.CompanyRepository;
import com.microservices.CompanyMs.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<CompanyWithReviewsDto> getAllCompanies() {
        List<Company> companies= companyRepository.findAll();
        List<CompanyWithReviewsDto> companyWithReviewsDtos=new ArrayList<>();
        for (Company company:companies){
            companyWithReviewsDtos.add(getObjects(company));
        }
        return companyWithReviewsDtos;
    }
    public CompanyWithReviewsDto getObjects(Company company) {
        String url = "http://REVIEW-SERVICE:8082/company/review/all/"+company.getCompId();
        ResponseEntity<List<Review>> response=restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>() {
        });
        List<Review> reviews=response.getBody();
        return ObjectMapper.mapper(company,reviews);
    }

    @Override
    public boolean updateCompany(Company company, int id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company companyToUpdate = companyOptional.get();
            if (company.getName() != null) {
                companyToUpdate.setName(company.getName());
            }
            if (company.getDescription() != null) {
                companyToUpdate.setDescription(company.getDescription());
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
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public CompanyWithReviewsDto getCompanyById(int id) {
        Company company= companyRepository.findById(id).orElse(null);
        if (company!=null){
            return getObjects(company);
        }
        return null;
    }
}
