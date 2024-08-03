package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Status;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
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
        List<Status> statusList = baseDAO.getAllEntity();
        if(statusList.isEmpty()){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return statusList;
    }

    @Override
    @Transactional
    public Status saveEntity(Status status) {
        return baseDAO.saveEntity(status);
    }

    @Override
    @Transactional
    public Status getEntity(int id) {
        Status status = baseDAO.getEntity(id);
        if(status==null){
            throw new NoSuchDataException("Статус с id - " + id + " отсутствует.");
        }
        return status;
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        Status status = baseDAO.getEntity(id);
        if(status==null){
            throw new NoSuchDataException("Статус с id - " + id + " отсутствует.");
        }
        baseDAO.deleteEntity(id);
    }
}
