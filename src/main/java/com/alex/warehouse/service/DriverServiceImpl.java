package com.alex.warehouse.service;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Driver;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements BaseService<Driver>{
    private BaseDAO<Driver> baseDAO;
    @Autowired
    public DriverServiceImpl(BaseDAO<Driver> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Driver> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Driver saveEntity(Driver driver) {
        return baseDAO.saveEntity(driver);
    }

    @Override
    @Transactional
    public Driver getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }
}
