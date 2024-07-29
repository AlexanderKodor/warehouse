package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.dto.BlankDTO;
import com.alex.warehouse.dto.InvoiceDTO;
import com.alex.warehouse.entity.Blank;
import com.alex.warehouse.entity.Employee;
import com.alex.warehouse.entity.Invoice;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.mapping.BlankMap;
import com.alex.warehouse.mapping.InvoiceMap;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlankServiceImpl implements BaseService<Blank> {
    private BaseDAO<Blank> baseDAO;
    private BaseDAO<Invoice> baseDAOInvoice;
    private BaseDAO<Employee> baseDAOEmployee;

    @Autowired
    public BlankServiceImpl(BaseDAO<Blank> baseDAO, BaseDAO<Invoice> baseDAOInvoice, BaseDAO<Employee> baseDAOEmployee) {
        this.baseDAO = baseDAO;
        this.baseDAOInvoice = baseDAOInvoice;
        this.baseDAOEmployee = baseDAOEmployee;
    }

    @Override
    @Transactional
    public List<Blank> getAllEntity() {
        return baseDAO.getAllEntity();
    }

    @Override
    @Transactional
    public Blank saveEntity(Blank blank) {
        return baseDAO.saveEntity(blank);
    }

    @Transactional
    public Invoice blankToInvoice(BlankDTO blankDTO) {
        if (blankDTO.getId() == 0) {
            throw new NoSuchDataException("Во входящих данных отсутствует id.");
        }
        Blank blankOld = baseDAO.getEntity(blankDTO.getId());
        if (blankOld == null) {
            throw new NoSuchDataException("Котировка с id - " + blankDTO.getId() + " отсутствует.");
        }
        Blank blank = BlankMap.mapping(blankDTO);
        blank.setDateCreate(blankOld.getDateCreate());
        InvoiceDTO invoiceDTO = null;
        if (blank.getStatus().getId() == 3) {
            if (baseDAOEmployee.getEntity(blankDTO.getEmployee_id()).getRole().getId() == 1
                    || baseDAOEmployee.getEntity(blankDTO.getEmployee_id()).getRole().getId() == 2) {
                blank.setEmployee(blankOld.getEmployee());
                blank.setDriver(blankOld.getDriver());
                blank.setTanker(blankOld.getTanker());
                blank.setRequest(blankOld.getRequest());
                invoiceDTO = new InvoiceDTO();
                invoiceDTO.setBlank_id(blankDTO.getId());
                invoiceDTO.setStatus_id(2);
            } else {
                throw new NoSuchDataException("У вас недостаточно прав.");
            }
        } else {
            throw new NoSuchDataException("Выбран не верный статус");
        }
        baseDAO.saveEntity(blank);
        Invoice invoice = InvoiceMap.mapping(invoiceDTO);
        invoice.setDateCreate(LocalDateTime.now());
        invoice.setDateInvoice(LocalDateTime.now());
        invoice.setEmployee(new Employee(blankDTO.getEmployee_id()));
        invoice.setNomenclature(blank.getRequest().getNomenclature());
        invoice.setCompany(blank.getRequest().getCompany());
        invoice.setQuantity(blank.getRequest().getQuantity());
        return baseDAOInvoice.saveEntity(invoice);
    }

    @Override
    @Transactional
    public Blank getEntity(int id) {
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        baseDAO.deleteEntity(id);
    }
}
