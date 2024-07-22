package com.alex.warehouse.controller;


import com.alex.warehouse.entity.Status;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatusRestController {
    private BaseService<Status> baseService;

    @Autowired
    public StatusRestController(BaseService<Status> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/status")
    public List<Status> showAllEntity(){
        List<Status> statusList = baseService.getAllEntity();
        if(statusList.isEmpty()){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return statusList;
    }
    @GetMapping("/status/search")
    public Status showEntity(@RequestParam("id") int id){
        Status status = baseService.getEntity(id);
        if(status==null){
            throw new NoSuchDataException("Статус с id - " + id + " отсутствует.");
        }
        return status;
    }

    @PostMapping("/status")
    public Status saveEntity(@RequestBody Status status){
        return baseService.saveEntity(status);
    }

    @PutMapping("/status")
    public Status updateEntity(@RequestBody Status status){
        return baseService.saveEntity(status);
    }

    @DeleteMapping("/status")
    public HandlingData delete(@RequestParam("id") int id){
        Status status = baseService.getEntity(id);
        if(status==null){
            throw new NoSuchDataException("Статус с id - " + id + " отсутствует.");
        }
        baseService.deleteEntity(id);
        return new HandlingData("Статус с id - " + id + " удален.");
    }
}

