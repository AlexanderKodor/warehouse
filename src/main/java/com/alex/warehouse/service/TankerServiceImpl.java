package com.alex.warehouse.service;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Tanker;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TankerServiceImpl implements BaseService<Tanker>{
    private BaseDAO<Tanker> baseDAO;
    @Autowired
    public TankerServiceImpl(BaseDAO<Tanker> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Tanker> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Tanker saveEntity(Tanker tanker) {
        return baseDAO.saveEntity(tanker);
    }

    @Override
    @Transactional
    public Tanker getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }
}
