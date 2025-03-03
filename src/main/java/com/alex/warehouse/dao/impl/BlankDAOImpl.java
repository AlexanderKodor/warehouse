package com.alex.warehouse.dao.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Blank;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class BlankDAOImpl implements BaseDAO<Blank> {

    private EntityManager entityManager;

    public BlankDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Blank> getAllEntity() {
        Query query = entityManager.createQuery("from Blank");
        List<Blank> blankList = query.getResultList();
        return blankList;
    }

    @Override
    public Blank saveEntity(Blank blank) {
        blank.setDateChange(LocalDateTime.now());
        Blank blankR = entityManager.merge(blank);
        return blankR;
    }

    @Override
    public Blank getEntity(int id) {
        Blank blank = entityManager.find(Blank.class, id);
        return blank;
    }

    @Override
    public void deleteEntity(int id) {
        Blank blank = entityManager.find(Blank.class, id);
        entityManager.remove(blank);
    }
}
