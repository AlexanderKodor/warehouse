package com.alex.warehouse.service;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Address;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements BaseService<Address>{

    private BaseDAO<Address> baseDAO;
    @Autowired
    public AddressServiceImpl(BaseDAO<Address> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Address> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Address saveEntity(Address address) {
        return baseDAO.saveEntity(address);
    }

    @Override
    @Transactional
    public Address getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }
}
