package com.alex.warehouse.dao;

import com.alex.warehouse.entity.Driver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DriverDAOImpl implements BaseDAO<Driver> {

    private EntityManager entityManager;
    @Autowired
    public DriverDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Driver> getAllEntity() {
        Query query = entityManager.createQuery("from Driver");
        List<Driver> driverList = query.getResultList();
        return driverList;
    }

    @Override
    public Driver saveEntity(Driver driver) {
        Driver driverReturn = entityManager.merge(driver);
        return driverReturn;
    }

    @Override
    public Driver getEntity(int id) {
        Driver driver = entityManager.find(Driver.class, id);
        return driver;
    }

    @Override
    public void deleteEntity(int id) {
        Driver driver = entityManager.find(Driver.class, id);
        entityManager.remove(driver);
    }
}
