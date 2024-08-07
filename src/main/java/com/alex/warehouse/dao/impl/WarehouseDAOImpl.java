package com.alex.warehouse.dao.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Nomenclature;
import com.alex.warehouse.entity.Warehouse;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WarehouseDAOImpl implements BaseDAO<Warehouse> {

    private EntityManager entityManager;

    public WarehouseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Warehouse> getAllEntity() {
        Query query = entityManager.createQuery("from Warehouse");
        List<Warehouse> warehouseList = query.getResultList();
        return warehouseList;
    }

    @Override
    public Warehouse saveEntity(Warehouse warehouse) {
        Warehouse warehouseReturn = entityManager.merge(warehouse);
        return warehouseReturn;
    }

    @Override
    public Warehouse getEntity(int id) {
        Warehouse warehouse = entityManager.find(Warehouse.class, id);
        return warehouse;
    }

    @Override
    public void deleteEntity(int id) {
        Warehouse warehouse = entityManager.find(Warehouse.class, id);
        entityManager.remove(warehouse);
    }

    public Warehouse getEntityByNomenclature(Nomenclature nomenclature){
        Query query = entityManager.createQuery("from Warehouse where nomenclature = :nomenclature");
        query.setParameter("nomenclature",nomenclature);
        List<Warehouse> resultList = query.getResultList();
        if(resultList.isEmpty()){
            throw new NoSuchDataException("Не найден склад с такой номенклатурой");
        }
        return resultList.get(0);
    }
}
