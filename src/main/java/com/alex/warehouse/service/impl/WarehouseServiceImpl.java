package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.impl.WarehouseDAOImpl;
import com.alex.warehouse.entity.Nomenclature;
import com.alex.warehouse.entity.Warehouse;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
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
        List<Warehouse> warehouseList = warehouseDAO.getAllEntity();
        if(warehouseList.isEmpty()){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return warehouseList;
    }

    @Override
    @Transactional
    public Warehouse saveEntity(Warehouse warehouse) {
        return warehouseDAO.saveEntity(warehouse);
    }

    @Override
    @Transactional
    public Warehouse getEntity(int id) {
        Warehouse warehouse = warehouseDAO.getEntity(id);
        if(warehouse==null){
            throw new NoSuchDataException("Склад с id - " + id + " отсутствует.");
        }
        return warehouse;
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        Warehouse warehouse = warehouseDAO.getEntity(id);
        if(warehouse==null){
            throw new NoSuchDataException("Склад с id - " + id + " отсутствует.");
        }
        warehouseDAO.deleteEntity(id);
    }

    public Warehouse getEntityByNomenclature(Nomenclature nomenclature){
        return warehouseDAO.getEntityByNomenclature(nomenclature);
    }

    public Warehouse addQuantity(Warehouse warehouseIN){
        if (warehouseIN.getQuantity()<=0){
            throw new NoSuchDataException("Пополнение не возможно, т.к. количество менее или равно 0.");
        }
        Warehouse warehouse = warehouseDAO.getEntity(warehouseIN.getId());
        warehouse.setQuantity(warehouse.getQuantity()+warehouseIN.getQuantity());
        return warehouseDAO.saveEntity(warehouse);
    }
}
