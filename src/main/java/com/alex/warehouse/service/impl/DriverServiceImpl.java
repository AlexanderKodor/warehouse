package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Driver;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements BaseService<Driver> {
    private BaseDAO<Driver> baseDAO;

    public DriverServiceImpl(BaseDAO<Driver> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Driver> getAllEntity() {
        List<Driver> driverList = baseDAO.getAllEntity();
        if (driverList.isEmpty()) {
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
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
        Driver driver = baseDAO.getEntity(id);
        if(driver==null){
            throw new NoSuchDataException("Водитель с id - " + id + " не найден.");
        }
        return driver;
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        Driver driver = baseDAO.getEntity(id);
        if(driver==null){
            throw new NoSuchDataException("Водитель с id - " + id + " не найден.");
        }
        baseDAO.deleteEntity(id);
    }
}
