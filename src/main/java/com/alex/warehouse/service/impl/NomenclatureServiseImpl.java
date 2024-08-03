package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Nomenclature;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
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
        List<Nomenclature> nomenclatureList = baseDAO.getAllEntity();
        if (nomenclatureList.isEmpty()) {
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
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
        Nomenclature nomenclature = baseDAO.getEntity(id);
        if(nomenclature==null){
            throw new NoSuchDataException("Номенклатура с id - " + id + " не найдена.");
        }
        return nomenclature;
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        Nomenclature nomenclature = baseDAO.getEntity(id);
        if(nomenclature==null){
            throw new NoSuchDataException("Номенклатура с id - " + id + " не найдена.");
        }
        baseDAO.deleteEntity(id);
    }
}
