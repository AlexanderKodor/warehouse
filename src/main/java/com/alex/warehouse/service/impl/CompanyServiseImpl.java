package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.impl.CompanyDAOImpl;
import com.alex.warehouse.entity.Company;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import com.alex.warehouse.service.ExtendedService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyServiseImpl implements BaseService<Company>, ExtendedService<Company> {
    CompanyDAOImpl companyDAOImpl;

    public CompanyServiseImpl(CompanyDAOImpl companyDAOImpl) {
        this.companyDAOImpl = companyDAOImpl;
    }

    @Override
    @Transactional
    public List<Company> getAllEntity() {
        List<Company> companyList = companyDAOImpl.getAllEntity();
        if (companyList.size() == 0) {
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return companyList;
    }

    @Override
    @Transactional
    public Company saveEntity(Company company) {
        return companyDAOImpl.saveEntity(company);
    }

    @Override
    @Transactional
    public Company getEntity(int id) {
        Company company = companyDAOImpl.getEntity(id);
        if (company == null) {
            throw new NoSuchDataException("Контрагент с id - " + id + " отсутствует.");
        }
        return company;
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        Company company = companyDAOImpl.getEntity(id);
        if (company == null) {
            throw new NoSuchDataException("Контрагент с id - " + id + " отсутствует.");
        }
        companyDAOImpl.deleteEntity(id);
    }

    @Override
    @Transactional
    public List<Company> dynamicFilter(Company company) {
        return companyDAOImpl.dynamicFilter(company);
    }
}
