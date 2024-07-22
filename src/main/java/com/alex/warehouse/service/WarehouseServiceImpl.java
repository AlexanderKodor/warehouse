package com.alex.warehouse.service;

import com.alex.warehouse.dao.WarehouseDAOImpl;
import com.alex.warehouse.entity.Nomenclature;
import com.alex.warehouse.entity.Warehouse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements BaseService<Warehouse>{
    private WarehouseDAOImpl warehouseDAO;
    @Autowired
    public WarehouseServiceImpl(WarehouseDAOImpl warehouseDAO) {
        this.warehouseDAO = warehouseDAO;
    }

    @Override
    @Transactional
    public List<Warehouse> getAllEntity() {
        return warehouseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Warehouse saveEntity(Warehouse warehouse) {
        return warehouseDAO.saveEntity(warehouse);
    }

    @Override
    @Transactional
    public Warehouse getEntity(int id) {
        return warehouseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        warehouseDAO.deleteEntity(id);
    }

    public Warehouse getEntityByNomenclature(Nomenclature nomenclature){
        return warehouseDAO.getEntityByNomenclature(nomenclature);
    }
}
