package com.alex.warehouse.controller;

import com.alex.warehouse.entity.Warehouse;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.impl.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Warehouse> warehouseList = warehouseService.getAllEntity();
        if(warehouseList.isEmpty()){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return warehouseList;
    }
    @GetMapping("/warehouse/search")
    public Warehouse showEntity(@RequestParam("id") int id){
        Warehouse warehouse = warehouseService.getEntity(id);
        if(warehouse==null){
            throw new NoSuchDataException("Склад с id - " + id + " отсутствует.");
        }
        return warehouse;
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
    public Warehouse addQuantity(@RequestBody Warehouse warehouseIN){
        if (warehouseIN.getQuantity()<=0){
            throw new NoSuchDataException("Пополнение не возможно, т.к. количество менее или равно 0.");
        }
        Warehouse warehouse = warehouseService.getEntity(warehouseIN.getId());
        warehouse.setQuantity(warehouse.getQuantity()+warehouseIN.getQuantity());
        return warehouseService.saveEntity(warehouse);
    }

    @DeleteMapping("/warehouse")
    public HandlingData delete(@RequestParam("id") int id){
        Warehouse warehouse = warehouseService.getEntity(id);
        if(warehouse==null){
            throw new NoSuchDataException("Склад с id - " + id + " отсутствует.");
        }
        warehouseService.deleteEntity(id);
        return new HandlingData("Склад с id - " + id + " удален.");
    }
}
