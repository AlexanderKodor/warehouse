package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Address;
import com.alex.warehouse.entity.Employee;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements BaseService<Employee> {
    private BaseDAO<Employee> baseDAO;

    public EmployeeServiceImpl(BaseDAO<Employee> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Employee> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Employee saveEntity(Employee employee) {
        return baseDAO.saveEntity(employee);
    }

    @Override
    @Transactional
    public Employee getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }
}
