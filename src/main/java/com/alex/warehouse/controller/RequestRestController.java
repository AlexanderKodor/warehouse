package com.alex.warehouse.controller;

import com.alex.warehouse.dto.RequestDTO;
import com.alex.warehouse.entity.Nomenclature;
import com.alex.warehouse.entity.Request;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.mapping.RequestMap;
import com.alex.warehouse.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestRestController {
    private BaseService<Request> baseService;

    @Autowired
    public RequestRestController(BaseService<Request> baseService) {
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
        if(request.getId()!=0){
            throw new NoSuchDataException("Методом POST нет возможности передачи id");
        }
        request.setDateCreate(LocalDateTime.now());
        request.setDateChange(LocalDateTime.now());
        return baseService.saveEntity(request);
    }

    //    @PutMapping("/request")
//    public Request updateEntity(@RequestBody Request request){
//        return baseService.saveEntity(request);
//    }
    @PutMapping("/request")
    public Request updateEntity(@RequestBody RequestDTO requestDTO) {
        if(requestDTO.getId()==0){
            throw new NoSuchDataException("Во входящих данных отсутствует id.");
        }
        Request requestOld = baseService.getEntity(requestDTO.getId());
        if (requestOld == null) {
            throw new NoSuchDataException("Заявка с id - " + requestDTO.getId() + " отсутствует.");
        }
        Request request = RequestMap.mapping(requestDTO);
        request.setDateCreate(requestOld.getDateCreate());
        request.setDateChange(LocalDateTime.now());
        return baseService.saveEntity(request);
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

