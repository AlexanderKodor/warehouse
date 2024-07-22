package com.alex.warehouse.dao;

import com.alex.warehouse.entity.Request;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class RequestDAOImpl implements BaseDAO<Request>{

    private EntityManager entityManager;
    @Autowired
    public RequestDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Request> getAllEntity() {
        Query query = entityManager.createQuery("from Request r order by r.id");
        List<Request> requestList = query.getResultList();
        return requestList;
    }

    @Override
    public Request saveEntity(Request request) {
        request.setDateChange(LocalDateTime.now());
        Request requestR = entityManager.merge(request);
        return requestR;
    }

    @Override
    public Request getEntity(int id) {
        Request request = entityManager.find(Request.class, id);
        return request;
    }

    @Override
    public void deleteEntity(int id) {
        Request request = entityManager.find(Request.class, id);
        entityManager.remove(request);
    }
}
