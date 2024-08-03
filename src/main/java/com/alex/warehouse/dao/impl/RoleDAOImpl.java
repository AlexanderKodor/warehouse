package com.alex.warehouse.dao.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements BaseDAO<Role> {

    private EntityManager entityManager;

    public RoleDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Role> getAllEntity() {
        Query query = entityManager.createQuery("from Role");
        List<Role> roleList = query.getResultList();
        return roleList;
    }

    @Override
    public Role saveEntity(Role role) {
        Role roleReturn = entityManager.merge(role);
        return roleReturn;
    }

    @Override
    public Role getEntity(int id) {
        Role role = entityManager.find(Role.class, id);
        return role;
    }

    @Override
    public void deleteEntity(int id) {
        Role role = entityManager.find(Role.class, id);
        entityManager.remove(role);
    }
}
