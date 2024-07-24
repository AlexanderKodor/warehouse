package com.alex.warehouse.dao.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDAOImpl implements BaseDAO<Address> {

    private EntityManager entityManager;
    @Autowired
    public AddressDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Address> getAllEntity() {
        Query query = entityManager.createQuery("from Address");
        List<Address> addressList = query.getResultList();
        return addressList;
    }

    @Override
    public Address saveEntity(Address address) {
        Address addressR = entityManager.merge(address);
        return addressR;
    }

    @Override
    public Address getEntity(int id) {
        Address address = entityManager.find(Address.class, id);
        return address;
    }

    @Override
    public void deleteEntity(int id) {
        Address address = entityManager.find(Address.class, id);
        entityManager.remove(address);
    }
}
