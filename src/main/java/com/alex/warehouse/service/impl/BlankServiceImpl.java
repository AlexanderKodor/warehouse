package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Blank;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlankServiceImpl implements BaseService<Blank> {
    private BaseDAO<Blank> baseDAO;

    @Autowired
    public BlankServiceImpl(BaseDAO<Blank> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Blank> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Blank saveEntity(Blank blank) {
        return baseDAO.saveEntity(blank);
    }

    @Override
    @Transactional
    public Blank getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }
}
