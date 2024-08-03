package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Role;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements BaseService<Role> {
    private BaseDAO<Role> baseDAO;

    public RoleServiceImpl(BaseDAO<Role> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Role> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Role saveEntity(Role role) {
        return baseDAO.saveEntity(role);
    }

    @Override
    @Transactional
    public Role getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }
}
