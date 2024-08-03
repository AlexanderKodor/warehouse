package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Employee;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
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
        List<Employee> employeeList = baseDAO.getAllEntity();
        if(employeeList.size()==0){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return employeeList;
    }

    @Override
    @Transactional
    public Employee saveEntity(Employee employee) {
        return baseDAO.saveEntity(employee);
    }

    @Override
    @Transactional
    public Employee getEntity(int id) {
        Employee employee = baseDAO.getEntity(id);
        if(employee==null){
            throw new NoSuchDataException("Работник с id - " + id + " отсутствует.");
        }
        return employee;
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        Employee employee = baseDAO.getEntity(id);
        if(employee==null){
            throw new NoSuchDataException("Работник с id - " + id + " отсутствует.");
        }
        baseDAO.deleteEntity(id);
    }
}
