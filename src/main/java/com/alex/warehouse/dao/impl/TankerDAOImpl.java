package com.alex.warehouse.dao.impl;

import com.alex.warehouse.entity.Tanker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface TankerDAOImpl extends JpaRepository<Tanker, Integer> {

    public List<Tanker> findAllByNumber(String number);

    public Tanker findByCertificateAndNumber(String cert, String number);

//    private EntityManager entityManager;
//    @Autowired
//    public TankerDAOImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<Tanker> getAllEntity() {
//        Query query = entityManager.createQuery("from Tanker");
//        List<Tanker> tankerList = query.getResultList();
//        return tankerList;
//    }
//
//    @Override
//    public Tanker saveEntity(Tanker tanker) {
//        Tanker tankerReturn = entityManager.merge(tanker);
//        return tankerReturn;
//    }
//
//    @Override
//    public Tanker getEntity(int id) {
//        Tanker tanker = entityManager.find(Tanker.class, id);
//        return tanker;
//    }
//
//    @Override
//    public void deleteEntity(int id) {
//        Tanker tanker = entityManager.find(Tanker.class, id);
//        entityManager.remove(tanker);
//    }
}
