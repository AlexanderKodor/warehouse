package com.alex.warehouse.dao;

import com.alex.warehouse.entity.Blank;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlankDAOImpl implements BaseDAO<Blank>{

    private EntityManager entityManager;
    @Autowired
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
