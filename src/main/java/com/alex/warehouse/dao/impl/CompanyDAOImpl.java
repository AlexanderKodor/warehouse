package com.alex.warehouse.dao.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.dao.ExtendedDAO;
import com.alex.warehouse.entity.Company;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAOImpl implements BaseDAO<Company>, ExtendedDAO<Company> {
    EntityManager entityManager;

    public CompanyDAOImpl(EntityManager entityManager) {
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
        return entityManager.merge(company);
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

    @Override
    public List<Company> dynamicFilter(Company company) {
        if(company==null){
            throw new NoSuchDataException("Фильтр не был передан");
        }
        StringBuilder where = new StringBuilder();
        if(company.getName() != null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.name LIKE \'%" + company.getName() + "%\' ");
        }
        if(company.getInn() != null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.inn LIKE \'%" + company.getInn() + "%\' ");
        }
        if(company.getKpp()!=null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.kpp LIKE \'%" + company.getKpp() + "%\' ");
        }
        if(company.getOgrn()!=null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.ogrn LIKE \'%" + company.getOgrn() + "%\' ");
        }
        if(company.getPhoneNumber()!=null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.phoneNumber LIKE \'%" + company.getPhoneNumber() + "%\' ");
        }
        if(company.getContactName()!=null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.contactName LIKE \'%" + company.getContactName() + "%\' ");
        }
        if(company.getEmail()!=null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.email LIKE \'%" + company.getEmail() + "%\' ");
        }
        if(company.getAddress().getPostIndex()!=null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.address.postIndex LIKE \'%" + company.getAddress().getPostIndex() + "%\' ");
        }
        if(company.getAddress().getCountry()!=null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.address.country LIKE \'%" + company.getAddress().getCountry() + "%\' ");
        }
        if(company.getAddress().getRegion()!=null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.address.region LIKE \'%" + company.getAddress().getRegion() + "%\' ");
        }
        if(company.getAddress().getCity()!=null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.address.city LIKE \'%" + company.getAddress().getCity() + "%\' ");
        }
        if(company.getAddress().getStreet()!=null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.address.street LIKE \'%" + company.getAddress().getStreet() + "%\' ");
        }
        if(company.getAddress().getHouse()!=null){
            if(where.length()>1){ where.append(" AND ");}
            where.append(" c.address.house LIKE \'%" + company.getAddress().getHouse() + "%\' ");
        }
        if(where.length()>1){
            where.insert(0, "WHERE ");
        }
        String hql = "from Company c " + where;
        Query query = entityManager.createQuery(hql, Company.class);
        List<Company> companyList = query.getResultList();

        return companyList;
    }
}
