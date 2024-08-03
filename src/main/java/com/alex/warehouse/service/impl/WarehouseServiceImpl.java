package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.impl.WarehouseDAOImpl;
import com.alex.warehouse.entity.Nomenclature;
import com.alex.warehouse.entity.Warehouse;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements BaseService<Warehouse> {
    private WarehouseDAOImpl warehouseDAO;
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
