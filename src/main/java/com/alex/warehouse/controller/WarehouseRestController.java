package com.alex.warehouse.controller;

import com.alex.warehouse.entity.Warehouse;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WarehouseRestController {
    private BaseService<Warehouse> baseService;

    @Autowired
    public WarehouseRestController(BaseService<Warehouse> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/warehouse")
    public List<Warehouse> showAllEntity(){
        List<Warehouse> warehouseList = baseService.getAllEntity();
        if(warehouseList.isEmpty()){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return warehouseList;
    }
    @GetMapping("/warehouse/search")
    public Warehouse showEntity(@RequestParam("id") int id){
        Warehouse warehouse = baseService.getEntity(id);
        if(warehouse==null){
            throw new NoSuchDataException("Склад с id - " + id + " отсутствует.");
        }
        return warehouse;
    }

    @PostMapping("/warehouse")
    public Warehouse saveEntity(@RequestBody Warehouse warehouse){
        return baseService.saveEntity(warehouse);
    }

    @PutMapping("/warehouse")
    public Warehouse updateEntity(@RequestBody Warehouse warehouse){
        return baseService.saveEntity(warehouse);
    }

    @DeleteMapping("/warehouse")
    public HandlingData delete(@RequestParam("id") int id){
        Warehouse warehouse = baseService.getEntity(id);
        if(warehouse==null){
            throw new NoSuchDataException("Склад с id - " + id + " отсутствует.");
        }
        baseService.deleteEntity(id);
        return new HandlingData("Склад с id - " + id + " удален.");
    }
}
