package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Address;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements BaseService<Address> {

    private BaseDAO<Address> baseDAO;

    public AddressServiceImpl(BaseDAO<Address> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Address> getAllEntity() {
        List<Address> addressList = baseDAO.getAllEntity();
        if (addressList.size()==0){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return addressList;
    }

    @Override
    @Transactional
    public Address saveEntity(Address address) {
        return baseDAO.saveEntity(address);
    }

    @Override
    @Transactional
    public Address getEntity(int id) {
        Address address = baseDAO.getEntity(id);
        if(address==null){
            throw new NoSuchDataException("Адрес с id - " + id + " отсутствует.");
        }
        return address;
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        Address address = baseDAO.getEntity(id);
        if (address == null) {
            throw new NoSuchDataException("Адрес с id - " + id + " отсутствует.");
        }
        baseDAO.deleteEntity(id);
    }
}
