package com.alex.warehouse.service;

import com.alex.warehouse.dao.CompanyRepository;
import com.alex.warehouse.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiseImpl implements BaseService<Company>, ExtendedService<Company>{
    CompanyRepository companyRepository;

    @Autowired
    public CompanyServiseImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllEntity() {
        return companyRepository.findAll();
    }

    @Override
    public Company saveEntity(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getEntity(int id) {
        Optional<Company> byId = companyRepository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    @Override
    public void deleteEntity(int id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<Company> dynamicFilter(Company company) {
        return null;//есть задумка, нужно время
    }
}
