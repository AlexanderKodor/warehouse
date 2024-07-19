package com.alex.warehouse.dao;

import com.alex.warehouse.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements BaseDAO<Employee>{

    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEntity() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public Employee saveEntity(Employee employee) {
        Employee employeeReturn = entityManager.merge(employee);
        return employeeReturn;
    }

    @Override
    public Employee getEntity(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEntity(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
