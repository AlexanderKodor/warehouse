package com.alex.warehouse.service;

import com.alex.warehouse.dao.CompanyRepository;
import com.alex.warehouse.entity.Company;
import com.alex.warehouse.exception_handling.NoSuchDataException;
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
        return companyRepository.getAllEntity();
    }

    @Override
    public Company saveEntity(Company company) {
        return companyRepository.saveEntity(company);
    }

    @Override
    public Company getEntity(int id) {
        return companyRepository.getEntity(id);
    }

    @Override
    public void deleteEntity(int id) {
        companyRepository.deleteEntity(id);
    }

    @Override
    public List<Company> dynamicFilter(Company company) {
        return null;//есть задумка, нужно время
    }
}
