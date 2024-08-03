package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Status;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements BaseService<Status> {
    private BaseDAO<Status> baseDAO;

    public StatusServiceImpl(BaseDAO<Status> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Status> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Status saveEntity(Status status) {
        return baseDAO.saveEntity(status);
    }

    @Override
    @Transactional
    public Status getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }
}
