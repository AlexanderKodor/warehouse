package com.alex.warehouse.dao;

import com.alex.warehouse.entity.Nomenclature;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NomenclatureDAOImpl implements BaseDAO<Nomenclature>{

    private EntityManager entityManager;
    @Autowired
    public NomenclatureDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Nomenclature> getAllEntity() {
        Query query = entityManager.createQuery("from Nomenclature");
        List<Nomenclature> nomenclatureList = query.getResultList();
        return nomenclatureList;
    }

    @Override
    public Nomenclature saveEntity(Nomenclature nomenclature) {
        Nomenclature nomenclatureReturn = entityManager.merge(nomenclature);
        return nomenclatureReturn;
    }

    @Override
    public Nomenclature getEntity(int id) {
        Nomenclature nomenclature = entityManager.find(Nomenclature.class, id);
        return nomenclature;
    }

    @Override
    public void deleteEntity(int id) {
        Nomenclature nomenclature = entityManager.find(Nomenclature.class, id);
        entityManager.remove(nomenclature);
    }
}
