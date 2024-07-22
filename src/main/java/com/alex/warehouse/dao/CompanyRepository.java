package com.alex.warehouse.dao;

import com.alex.warehouse.entity.Company;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyRepository implements BaseDAO<Company>, ExtendedDAO<Company>{
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

    @Override
    public List<Company> dynamicFilter(Company company) {
        if(company==null){
            throw new NoSuchDataException("Фильтр не был передан");
        }
        String where = "";
        if(company.getInn() != null){
            where = where + " c.inn LIKE \'%" + company.getInn() + "%\' ";
        }
        if(company.getKpp()!=null){
            if(where.length()>1){ where = where + " AND ";}
            where = where + " c.kpp LIKE \'%" + company.getKpp() + "%\' ";
        }
        if(company.getOgrn()!=null){
            if(where.length()>1){ where = where + " AND ";}
            where = where + " c.ogrn LIKE \'%" + company.getOgrn() + "%\' ";
        }
        if(company.getPhoneNumber()!=null){
            if(where.length()>1){ where = where + " AND ";}
            where = where + " c.phoneNumber LIKE \'%" + company.getPhoneNumber() + "%\' ";
        }
        if(company.getContactName()!=null){
            if(where.length()>1){ where = where + " AND ";}
            where = where + " c.contactName LIKE \'%" + company.getContactName() + "%\' ";
        }
        if(company.getEmail()!=null){
            if(where.length()>1){ where = where + " AND ";}
            where = where + " c.email LIKE \'%" + company.getEmail() + "%\' ";
        }
        if(company.getAddress().getPostIndex()!=null){
            if(where.length()>1){ where = where + " AND ";}
            where = where + " c.address.postIndex LIKE \'%" + company.getAddress().getPostIndex() + "%\' ";
        }
        if(company.getAddress().getCountry()!=null){
            if(where.length()>1){ where = where + " AND ";}
            where = where + " c.address.country LIKE \'%" + company.getAddress().getCountry() + "%\' ";
        }
        if(company.getAddress().getRegion()!=null){
            if(where.length()>1){ where = where + " AND ";}
            where = where + " c.address.region LIKE \'%" + company.getAddress().getRegion() + "%\' ";
        }
        if(company.getAddress().getCity()!=null){
            if(where.length()>1){ where = where + " AND ";}
            where = where + " c.address.city LIKE \'%" + company.getAddress().getCity() + "%\' ";
        }
        if(company.getAddress().getStreet()!=null){
            if(where.length()>1){ where = where + " AND ";}
            where = where + " c.address.street LIKE \'%" + company.getAddress().getStreet() + "%\' ";
        }
        if(company.getAddress().getHouse()!=null){
            if(where.length()>1){ where = where + " AND ";}
            where = where + " c.address.house LIKE \'%" + company.getAddress().getHouse() + "%\' ";
        }
        if(where!=null){
            where = "WHERE " + where;
        }
        String hql = "from Company c " + where;
        Query query = entityManager.createQuery(hql, Company.class);
        List<Company> companyList = query.getResultList();

        return companyList;
    }
}
