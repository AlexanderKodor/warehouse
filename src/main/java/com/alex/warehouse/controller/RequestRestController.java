package com.alex.warehouse.controller;

import com.alex.warehouse.dto.BlankDTO;
import com.alex.warehouse.dto.RequestDTO;
import com.alex.warehouse.entity.*;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.mapping.BlankMap;
import com.alex.warehouse.mapping.RequestMap;
import com.alex.warehouse.service.BaseService;
import com.alex.warehouse.service.impl.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestRestController {
    private RequestServiceImpl baseService;


    @Autowired
    public RequestRestController(RequestServiceImpl baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/request")
    public List<Request> showAllEntity() {
        List<Request> requestList = baseService.getAllEntity();
        if (requestList.isEmpty()) {
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return requestList;
    }

    @GetMapping("/request/search")
    public Request showEntity(@RequestParam("id") int id) {
        Request request = baseService.getEntity(id);
        if (request == null) {
            throw new NoSuchDataException("Заявка с id - " + id + " отсутствует.");
        }
        return request;
    }

    //    @PostMapping("/request")
//    public Request saveEntity(@RequestBody Request request){
//        return baseService.saveEntity(request);
//    }
    @PostMapping("/request")
    public Request saveEntity(@RequestBody RequestDTO requestDTO) {
        Request request = RequestMap.mapping(requestDTO);
        if (request.getId() != 0) {
            throw new NoSuchDataException("Методом POST нет возможности передачи id");
        }
        switch (request.getStatus().getId()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                throw new NoSuchDataException("У вас не достаточно прав для установки данного статуса заявки.");
            default:
                throw new NoSuchDataException("Неизвестный статус.");
        }
        request.setDateCreate(LocalDateTime.now());
        return baseService.saveEntity(request);
    }

    //    @PutMapping("/request")
//    public Request updateEntity(@RequestBody Request request){
//        return baseService.saveEntity(request);
//    }
    @PutMapping("/request")
    public Request updateEntity(@RequestBody RequestDTO requestDTO) {
        if (requestDTO.getId() == 0) {
            throw new NoSuchDataException("Во входящих данных отсутствует id.");
        }
        Request requestOld = baseService.getEntity(requestDTO.getId());
        if (requestOld == null) {
            throw new NoSuchDataException("Заявка с id - " + requestDTO.getId() + " отсутствует.");
        }
        Request request = RequestMap.mapping(requestDTO);
        switch (request.getStatus().getId()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                throw new NoSuchDataException("У вас не достаточно прав для установки данного статуса заявки.");
            default:
                throw new NoSuchDataException("Неизвестный статус.");
        }
        request.setDateCreate(requestOld.getDateCreate());
        return baseService.saveEntity(request);
    }

    @PutMapping("/request-to-blank")
    public Blank requestToBlank(@RequestBody RequestDTO requestDTO) {
        return baseService.requestToBlank(requestDTO);
    }

    @DeleteMapping("/request")
    public HandlingData delete(@RequestParam("id") int id) {
        Request request = baseService.getEntity(id);
        if (request == null) {
            throw new NoSuchDataException("Заявка с id - " + id + " отсутствует.");
        }
        baseService.deleteEntity(id);
        return new HandlingData("Заявка с id - " + id + " удалена.");
    }
}

