package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Nomenclature;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NomenclatureServiseImpl implements BaseService<Nomenclature> {
    private BaseDAO<Nomenclature> baseDAO;

    public NomenclatureServiseImpl(BaseDAO<Nomenclature> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Nomenclature> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Nomenclature saveEntity(Nomenclature nomenclature) {
        return baseDAO.saveEntity(nomenclature);
    }

    @Override
    @Transactional
    public Nomenclature getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }
}
