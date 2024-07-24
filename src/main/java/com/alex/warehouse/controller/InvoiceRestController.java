package com.alex.warehouse.controller;

import com.alex.warehouse.dto.InvoiceDTO;
import com.alex.warehouse.entity.Blank;
import com.alex.warehouse.entity.Invoice;
import com.alex.warehouse.entity.Status;
import com.alex.warehouse.entity.Warehouse;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.mapping.InvoiceMap;
import com.alex.warehouse.service.BaseService;
import com.alex.warehouse.service.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceRestController {
    BaseService<Invoice> baseService;
    BaseService<Blank> baseServiceBlank;
    WarehouseServiceImpl warehouseService;

    @Autowired
    public InvoiceRestController(BaseService<Invoice> baseService, BaseService<Blank> baseServiceBlank, WarehouseServiceImpl warehouseService) {
        this.baseService = baseService;
        this.baseServiceBlank = baseServiceBlank;
        this.warehouseService = warehouseService;
    }

    @GetMapping("/invoice")
    public List<Invoice> showAllEntity(){
        List<Invoice> invoiceList = baseService.getAllEntity();
        if(invoiceList.isEmpty()){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return invoiceList;
    }

    @GetMapping("/invoice/search")
    public Invoice showEntity(@RequestParam("id") int id){
        Invoice invoice = baseService.getEntity(id);
        if(invoice==null){
            throw new NoSuchDataException("Накладная с id - " + id + " отсутствует.");
        }
        return invoice;
    }
//создаётся на основании котировки - blank
//    @PostMapping("/invoice")
//    public Invoice saveEntity(@RequestBody InvoiceDTO invoiceDTO){
//        Invoice invoice = InvoiceMap.mapping(invoiceDTO);
//        if(invoice.getId()!=0){
//            throw new NoSuchDataException("Методом POST нет возможности передачи id");
//        }
//        invoice.setDateCreate(LocalDateTime.now());
//        invoice.setDateChange(LocalDateTime.now());
//        return baseService.saveEntity(invoice);
//    }

    @PutMapping("/invoice")
    public Invoice updateEntity(@RequestBody InvoiceDTO invoiceDTO){
        if(invoiceDTO.getId()==0){
            throw new NoSuchDataException("Во входящих данных отсутствует id.");
        }
        Invoice invoiceOld = baseService.getEntity(invoiceDTO.getId());
        if (invoiceOld == null) {
            throw new NoSuchDataException("Накладная с id - " + invoiceDTO.getId() + " отсутствует.");
        }
        Invoice invoice = InvoiceMap.mapping(invoiceDTO);
        invoice.setDateCreate(invoiceOld.getDateCreate());
        invoice.setDateChange(LocalDateTime.now());
        if (invoice.getStatus().getId()==3){
            Warehouse warehouse = warehouseService.getEntityByNomenclature(invoiceOld.getNomenclature());
            if((warehouse.getQuantity()-invoice.getQuantity())>0) {
                warehouse.setQuantity(warehouse.getQuantity() - invoice.getQuantity());
                warehouseService.saveEntity(warehouse);
            }
            else {
                throw new NoSuchDataException("На складе не оказалось достаточно топлива");
            }
        }
        return baseService.saveEntity(invoice);
    }
//    @PostMapping("/invoice")
//    public Invoice saveEntity(@RequestBody Invoice invoice){
//        return baseService.saveEntity(invoice);
//    }
//
//    @PutMapping("/invoice")
//    public Invoice updateEntity(@RequestBody Invoice invoice){
//        return baseService.saveEntity(invoice);
//    }

    @DeleteMapping("/invoice")
    public HandlingData deleteEntity(@RequestParam("id") int id){
        Invoice invoice = baseService.getEntity(id);
        if(invoice==null){
            throw new NoSuchDataException("Накладная с id - " + id + " отсутствует.");
        }
        //т.к. номенклатура создаётся только приодобрении котировки, то при удалении его - котировка должна менять статус на "в ожидании"
        Blank blank = invoice.getBlank();
        blank.setStatus(new Status(2));
        baseServiceBlank.saveEntity(blank);
        baseService.deleteEntity(id);
        return new HandlingData("Накладная с id - " + id + " удалёна.");
    }
}
