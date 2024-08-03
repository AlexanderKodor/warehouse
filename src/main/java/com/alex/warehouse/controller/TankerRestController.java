package com.alex.warehouse.controller;


import com.alex.warehouse.entity.Tanker;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TankerRestController {
    private BaseService<Tanker> baseService;

    public TankerRestController(BaseService<Tanker> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/tanker")
    public List<Tanker> showAllEntity(){
        return baseService.getAllEntity();
    }
    @GetMapping("/tanker/search")
    public Tanker showEntity(@RequestParam("id") int id){
        return baseService.getEntity(id);
    }

    @PostMapping("/tanker")
    public Tanker saveEntity(@RequestBody Tanker tanker){
        return baseService.saveEntity(tanker);
    }

    @PutMapping("/tanker")
    public Tanker updateEntity(@RequestBody Tanker tanker){
        return baseService.saveEntity(tanker);
    }

    @DeleteMapping("/tanker")
    public HandlingData delete(@RequestParam("id") int id){
        baseService.deleteEntity(id);
        return new HandlingData("Бензовоз с id - " + id + " удален.");
    }
}
