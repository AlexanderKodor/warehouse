package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Request;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements BaseService<Request> {
    private BaseDAO<Request> baseDAO;
    @Autowired
    public RequestServiceImpl(BaseDAO<Request> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Request> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Request saveEntity(Request request) {
        return baseDAO.saveEntity(request);
    }

    @Override
    @Transactional
    public Request getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }
}
