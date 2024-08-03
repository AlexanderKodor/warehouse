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
import com.alex.warehouse.service.impl.InvoiceServiceImpl;
import com.alex.warehouse.service.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceRestController {
    InvoiceServiceImpl baseService;
    BaseService<Blank> baseServiceBlank;

    public InvoiceRestController(InvoiceServiceImpl baseService, BaseService<Blank> baseServiceBlank) {
        this.baseService = baseService;
        this.baseServiceBlank = baseServiceBlank;
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

    @PutMapping("/invoice")
    public Invoice updateEntity(@RequestBody InvoiceDTO invoiceDTO){
        return baseService.updateEntity(invoiceDTO);
    }

    @DeleteMapping("/invoice")
    public HandlingData deleteEntity(@RequestParam("id") int id){
        Invoice invoice = baseService.getEntity(id);
        if(invoice==null){
            throw new NoSuchDataException("Накладная с id - " + id + " отсутствует.");
        }
        //т.к. накладная создаётся только приодобрении котировки, то при удалении его - котировка должна менять статус на "в ожидании"
        Blank blank = invoice.getBlank();
        blank.setStatus(new Status(2));
        baseServiceBlank.saveEntity(blank);
        baseService.deleteEntity(id);
        return new HandlingData("Накладная с id - " + id + " удалёна.");
    }
}
