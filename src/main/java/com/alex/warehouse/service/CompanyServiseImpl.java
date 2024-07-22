package com.alex.warehouse.service;

import com.alex.warehouse.dao.CompanyRepository;
import com.alex.warehouse.entity.Company;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyServiseImpl implements BaseService<Company>, ExtendedService<Company>{
    CompanyRepository companyRepository;

    @Autowired
    public CompanyServiseImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    @Transactional
    public List<Company> getAllEntity() {
        return companyRepository.getAllEntity();
    }

    @Override
    @Transactional
    public Company saveEntity(Company company) {
        return companyRepository.saveEntity(company);
    }

    @Override
    @Transactional
    public Company getEntity(int id) {
        return companyRepository.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        companyRepository.deleteEntity(id);
    }

    @Override
    @Transactional
    public List<Company> dynamicFilter(Company company) {
        return companyRepository.dynamicFilter(company);
    }
}
