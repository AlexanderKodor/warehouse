package com.alex.warehouse.dao;

import com.alex.warehouse.entity.Status;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatusDAOImpl implements BaseDAO<Status> {

    private EntityManager entityManager;
    @Autowired
    public StatusDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Status> getAllEntity() {
        Query query = entityManager.createQuery("from Status");
        List<Status> statusList = query.getResultList();
        return statusList;
    }

    @Override
    public Status saveEntity(Status status) {
        Status statusReturn = entityManager.merge(status);
        return statusReturn;
    }

    @Override
    public Status getEntity(int id) {
        Status status = entityManager.find(Status.class, id);
        return status;
    }

    @Override
    public void deleteEntity(int id) {
        Status status = entityManager.find(Status.class, id);
        entityManager.remove(status);
    }
}
