package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.entity.Invoice;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements BaseService<Invoice> {
    private BaseDAO<Invoice> baseDAO;
    @Autowired
    public InvoiceServiceImpl(BaseDAO<Invoice> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    @Transactional
    public List<Invoice> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Invoice saveEntity(Invoice invoice) {
        return baseDAO.saveEntity(invoice);
    }

    @Override
    @Transactional
    public Invoice getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }
}
