package com.microservices.JobMs.client;

import com.microservices.JobMs.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY-SERVICE")
public interface CompanyClient {
    @GetMapping("/company/find/{id}")
    Company getCompany(@PathVariable("id") int id);
}
