package com.alex.warehouse.controller;


import com.alex.warehouse.entity.Status;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatusRestController {
    private BaseService<Status> baseService;

    public StatusRestController(BaseService<Status> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/status")
    public List<Status> showAllEntity(){
        return baseService.getAllEntity();
    }
    @GetMapping("/status/search")
    public Status showEntity(@RequestParam("id") int id){
        return baseService.getEntity(id);
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
        baseService.deleteEntity(id);
        return new HandlingData("Статус с id - " + id + " удален.");
    }
}

