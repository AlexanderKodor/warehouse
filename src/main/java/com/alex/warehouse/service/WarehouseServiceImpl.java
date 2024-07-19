package com.alex.warehouse.service;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Warehouse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements BaseService<Warehouse>{
    private BaseDAO<Warehouse> baseDAO;
    @Autowired
    public WarehouseServiceImpl(BaseDAO<Warehouse> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Warehouse> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Warehouse saveEntity(Warehouse warehouse) {
        return baseDAO.saveEntity(warehouse);
    }

    @Override
    @Transactional
    public Warehouse getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }
}
