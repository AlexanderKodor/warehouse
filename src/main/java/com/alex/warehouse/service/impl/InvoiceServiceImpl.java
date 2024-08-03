package com.alex.warehouse.service.impl;

import com.alex.warehouse.dao.BaseDAO;
import com.alex.warehouse.dao.impl.WarehouseDAOImpl;
import com.alex.warehouse.dto.InvoiceDTO;
import com.alex.warehouse.entity.Blank;
import com.alex.warehouse.entity.Invoice;
import com.alex.warehouse.entity.Status;
import com.alex.warehouse.entity.Warehouse;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.mapping.InvoiceMap;
import com.alex.warehouse.service.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoiceServiceImpl implements BaseService<Invoice> {
    private BaseDAO<Invoice> baseDAO;
    private BaseDAO<Blank> baseDAOBlank;
    private WarehouseDAOImpl warehouseDAO;

    public InvoiceServiceImpl(BaseDAO<Invoice> baseDAO, WarehouseDAOImpl warehouseDAO) {
        this.baseDAO = baseDAO;
        this.warehouseDAO = warehouseDAO;
    }

    @Override
    @Transactional
    public List<Invoice> getAllEntity() {
        List<Invoice> invoiceList = baseDAO.getAllEntity();
        if(invoiceList.isEmpty()){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return invoiceList;
    }

    @Override
    @Transactional
    public Invoice saveEntity(Invoice invoice) {
        return baseDAO.saveEntity(invoice);
    }

    @Override
    @Transactional
    public Invoice getEntity(int id) {
        Invoice invoice = baseDAO.getEntity(id);
        if(invoice==null){
            throw new NoSuchDataException("Накладная с id - " + id + " отсутствует.");
        }
        return baseDAO.getEntity(id);
    }

    @Override
    @Transactional
    public void deleteEntity(int id) {
        Invoice invoice = baseDAO.getEntity(id);
        if(invoice==null){
            throw new NoSuchDataException("Накладная с id - " + id + " отсутствует.");
        }
        //т.к. накладная создаётся только приодобрении котировки, то при удалении его - котировка должна менять статус на "в ожидании"
        Blank blank = invoice.getBlank();
        blank.setStatus(new Status(2));
        baseDAOBlank.saveEntity(blank);
        baseDAO.deleteEntity(id);
    }

    @Transactional
    public Invoice updateEntity(InvoiceDTO invoiceDTO) {
        if(invoiceDTO.getId()==0){
            throw new NoSuchDataException("Во входящих данных отсутствует id.");
        }
        Invoice invoiceOld = baseDAO.getEntity(invoiceDTO.getId());
        if (invoiceOld == null) {
            throw new NoSuchDataException("Накладная с id - " + invoiceDTO.getId() + " отсутствует.");
        }
        Invoice invoice = InvoiceMap.mapping(invoiceDTO);
        invoice.setDateCreate(invoiceOld.getDateCreate());
        invoice.setDateChange(LocalDateTime.now());
        if (invoice.getStatus().getId()==3){
            Warehouse warehouse = warehouseDAO.getEntityByNomenclature(invoiceOld.getNomenclature());
            if((warehouse.getQuantity()-invoice.getQuantity())>0) {
                warehouse.setQuantity(warehouse.getQuantity() - invoice.getQuantity());
                warehouseDAO.saveEntity(warehouse);
            }
            else {
                throw new NoSuchDataException("На складе не оказалось достаточно топлива");
            }
        }
        return baseDAO.saveEntity(invoice);
    }
}
