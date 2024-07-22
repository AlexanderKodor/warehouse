package com.alex.warehouse.dao;

import com.alex.warehouse.entity.Company;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository implements BaseDAO<Company> {
    EntityManager entityManager;

    @Autowired
    public CompanyRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Company> getAllEntity() {
        Query query = entityManager.createQuery("from Company ", Company.class);
        List<Company> companyList = query.getResultList();
        return companyList;
    }

    @Override
    public Company saveEntity(Company company) {
        Company temp=null;
        if(company.getId()!=0 && entityManager.find(Company.class, company.getId())!=null){
            entityManager.merge(company);
        }
        throw new NoSuchDataException("Передан не существующий id контрагента");
    }

    @Override
    public Company getEntity(int id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void deleteEntity(int id) {
        Company company = entityManager.find(Company.class, id);
        entityManager.remove(company);
    }
}
