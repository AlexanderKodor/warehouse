package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Role;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
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
        List<Role> roleList = baseDAO.getAllEntity();
        if(roleList.isEmpty()){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return roleList;
    }

    @Override
    @Transactional
    public Role saveEntity(Role role) {
        return baseDAO.saveEntity(role);
    }

    @Override
    @Transactional
    public Role getEntity(int id) {
        Role role = baseDAO.getEntity(id);
        if(role==null){
            throw new NoSuchDataException("Роль с id - " + id + " отсутствует.");
        }
        return role;
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        Role role = baseDAO.getEntity(id);
        if(role==null){
            throw new NoSuchDataException("Роль с id - " + id + " отсутствует.");
        }
        baseDAO.deleteEntity(id);
    }
}
