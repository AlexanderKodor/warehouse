package com.alex.warehouse.controller;

import com.alex.warehouse.dto.InvoiceDTO;
import com.alex.warehouse.entity.Blank;
import com.alex.warehouse.entity.Invoice;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.service.BaseService;
import com.alex.warehouse.service.impl.InvoiceServiceImpl;
import org.springframework.web.bind.annotation.*;

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
        return baseService.getAllEntity();
    }

    @GetMapping("/invoice/search")
    public Invoice showEntity(@RequestParam("id") int id){
        return baseService.getEntity(id);
    }

    @PutMapping("/invoice")
    public Invoice updateEntity(@RequestBody InvoiceDTO invoiceDTO){
        return baseService.updateEntity(invoiceDTO);
    }

    @DeleteMapping("/invoice")
    public HandlingData deleteEntity(@RequestParam("id") int id){
        baseService.deleteEntity(id);
        return new HandlingData("Накладная с id - " + id + " удалёна.");
    }
}
