package com.alex.warehouse.controller;

import com.alex.warehouse.dto.BlankDTO;
import com.alex.warehouse.entity.*;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.mapping.BlankMap;
import com.alex.warehouse.service.BaseService;
import com.alex.warehouse.service.impl.BlankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class BlankRestController {
    private BlankServiceImpl baseService;
    private BaseService<Request> baseServiceRequest;
    private BaseService<Invoice> baseServiceInvoice;
    private BaseService<Employee> baseServiceEmployee;
    @Autowired
    public BlankRestController(BlankServiceImpl baseService, BaseService<Request> baseServiceRequest, BaseService<Invoice> baseServiceInvoice, BaseService<Employee> baseServiceEmployee) {
        this.baseService = baseService;
        this.baseServiceRequest = baseServiceRequest;
        this.baseServiceInvoice = baseServiceInvoice;
        this.baseServiceEmployee = baseServiceEmployee;
    }

    @GetMapping("/blank")
    public List<Blank> showAllEntity(){
        List<Blank> blankList = baseService.getAllEntity();
        if(blankList.size()==0){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return blankList;
    }
    @GetMapping("/blank/search")
    public Blank showEntity(@RequestParam("id") int id){
        Blank blank = baseService.getEntity(id);
        if(blank==null){
            throw new NoSuchDataException("Котировка с id - " + id + " отсутствует.");
        }
        return blank;
    }

    //откуда возьмётся котровка если нет заявки?
//    @PostMapping("/blank")
//    public Blank saveEntity(@RequestBody BlankDTO blankDTO){
//        Blank blank = BlankMap.mapping(blankDTO);
//        if(blank.getId()!=0){
//            throw new NoSuchDataException("Методом POST нет возможности передачи id");
//        }
//        blank.setDateCreate(LocalDateTime.now());
//        return baseService.saveEntity(blank);
//    }

    @PutMapping("/blank")
    public Blank updateEntity(@RequestBody BlankDTO blankDTO){
        if(blankDTO.getId()==0){
            throw new NoSuchDataException("Во входящих данных отсутствует id.");
        }
        Blank blankOld = baseService.getEntity(blankDTO.getId());
        if (blankOld == null) {
            throw new NoSuchDataException("Котировка с id - " + blankDTO.getId() + " отсутствует.");
        }
        Blank blank = BlankMap.mapping(blankDTO);
        blank.setDateCreate(blankOld.getDateCreate());
        return baseService.saveEntity(blank);
    }

    @PutMapping("/blank-to-invoice")
    public Invoice blankToInvoice(@RequestBody BlankDTO blankDTO) {
        return baseService.blankToInvoice(blankDTO);
    }

//    @PostMapping("/blank")
//    public Blank saveEntity(@RequestBody Blank blank){
//        return baseService.saveEntity(blank);
//    }
//
//    @PutMapping("/blank")
//    public Blank updateEntity(@RequestBody Blank blank){
//        return baseService.saveEntity(blank);
//    }

    @DeleteMapping("/blank")
    public HandlingData delete(@RequestParam("id") int id){
        Blank blank = baseService.getEntity(id);
        if(blank==null){
            throw new NoSuchDataException("Котировка с id - " + id + " отсутствует.");
        }
        //т.к. бланк создаётся только приодобрении заявки, то при удалении его - заявка должна менять статус на "в ожидании"
        Request request = blank.getRequest();
        request.setStatus(new Status(2));
        baseServiceRequest.saveEntity(request);
        baseService.deleteEntity(id);
        return new HandlingData("Котировка с id - " + id + " удалена.");
    }
}
