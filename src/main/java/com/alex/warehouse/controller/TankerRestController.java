package com.alex.warehouse.controller;


import com.alex.warehouse.entity.Tanker;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TankerRestController {
    private BaseService<Tanker> baseService;

    @Autowired
    public TankerRestController(BaseService<Tanker> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/tanker")
    public List<Tanker> showAllEntity(){
        List<Tanker> tankerList = baseService.getAllEntity();
        if(tankerList.isEmpty()){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return tankerList;
    }
    @GetMapping("/tanker/search")
    public Tanker showEntity(@RequestParam("id") int id){
        Tanker tanker = baseService.getEntity(id);
        if(tanker==null){
            throw new NoSuchDataException("Бензовоз с id - " + id + " отсутствует.");
        }
        return tanker;
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
        Tanker tanker = baseService.getEntity(id);
        if(tanker==null){
            throw new NoSuchDataException("Бензовоз с id - " + id + " отсутствует.");
        }
        baseService.deleteEntity(id);
        return new HandlingData("Бензовоз с id - " + id + " удален.");
    }
}
