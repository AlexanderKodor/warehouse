package com.alex.warehouse.controller;

import com.alex.warehouse.dto.BlankDTO;
import com.alex.warehouse.entity.Blank;
import com.alex.warehouse.entity.Employee;
import com.alex.warehouse.entity.Invoice;
import com.alex.warehouse.entity.Request;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.mapping.BlankMap;
import com.alex.warehouse.service.BaseService;
import com.alex.warehouse.service.impl.BlankServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlankRestController {
    private BlankServiceImpl baseService;
    private BaseService<Request> baseServiceRequest;
    private BaseService<Invoice> baseServiceInvoice;
    private BaseService<Employee> baseServiceEmployee;

    public BlankRestController(BlankServiceImpl baseService, BaseService<Request> baseServiceRequest, BaseService<Invoice> baseServiceInvoice, BaseService<Employee> baseServiceEmployee) {
        this.baseService = baseService;
        this.baseServiceRequest = baseServiceRequest;
        this.baseServiceInvoice = baseServiceInvoice;
        this.baseServiceEmployee = baseServiceEmployee;
    }

    @GetMapping("/blank")
    public List<Blank> showAllEntity(){
        return baseService.getAllEntity();
    }
    @GetMapping("/blank/search")
    public Blank showEntity(@RequestParam("id") int id){
        return baseService.getEntity(id);
    }

    @PutMapping("/blank")
    public Blank updateEntity(@RequestBody BlankDTO blankDTO){
        Blank blank = BlankMap.mapping(blankDTO);
        return baseService.saveEntity(blank);
    }

    @PutMapping("/blank-to-invoice")
    public Invoice blankToInvoice(@RequestBody BlankDTO blankDTO) {
        return baseService.blankToInvoice(blankDTO);
    }

    @DeleteMapping("/blank")
    public HandlingData delete(@RequestParam("id") int id){
        baseService.deleteEntity(id);
        return new HandlingData("Котировка с id - " + id + " удалена.");
    }
}
