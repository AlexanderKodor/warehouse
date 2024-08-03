package com.alex.warehouse.controller;

import com.alex.warehouse.entity.Warehouse;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.service.impl.WarehouseServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WarehouseRestController {
    private WarehouseServiceImpl warehouseService;

    public WarehouseRestController(WarehouseServiceImpl warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/warehouse")
    public List<Warehouse> showAllEntity(){
        return warehouseService.getAllEntity();
    }
    @GetMapping("/warehouse/search")
    public Warehouse showEntity(@RequestParam("id") int id){
        return warehouseService.getEntity(id);
    }

    @PostMapping("/warehouse")
    public Warehouse saveEntity(@RequestBody Warehouse warehouse){
        return warehouseService.saveEntity(warehouse);
    }

    @PutMapping("/warehouse")
    public Warehouse updateEntity(@RequestBody Warehouse warehouse){
        return warehouseService.saveEntity(warehouse);
    }

    @PutMapping("/warehouse-add-fuel")
    public Warehouse addQuantity(@RequestBody Warehouse warehouse){
        return warehouseService.addQuantity(warehouse);
    }

    @DeleteMapping("/warehouse")
    public HandlingData delete(@RequestParam("id") int id){
        warehouseService.deleteEntity(id);
        return new HandlingData("Склад с id - " + id + " удален.");
    }
}
