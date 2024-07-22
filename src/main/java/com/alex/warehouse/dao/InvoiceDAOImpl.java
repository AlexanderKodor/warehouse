package com.alex.warehouse.dao;

import com.alex.warehouse.entity.Invoice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class InvoiceDAOImpl implements BaseDAO<Invoice> {

    private EntityManager entityManager;
    @Autowired
    public InvoiceDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Invoice> getAllEntity() {
        Query query = entityManager.createQuery("from Invoice");
        List<Invoice> invoiceList = query.getResultList();
        return invoiceList;
    }

    @Override
    public Invoice saveEntity(Invoice invoice) {
        invoice.setDateChange(LocalDateTime.now());
        Invoice invoiceR = entityManager.merge(invoice);
        return invoiceR;
    }

    @Override
    public Invoice getEntity(int id) {
        Invoice invoice = entityManager.find(Invoice.class, id);
        return invoice;
    }

    @Override
    public void deleteEntity(int id) {
        Invoice invoice = entityManager.find(Invoice.class, id);
        entityManager.remove(invoice);
    }
}
