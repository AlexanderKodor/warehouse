package com.alex.warehouse.controller;

import com.alex.warehouse.entity.Driver;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.service.impl.DriverServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverRestController {
    private DriverServiceImpl driverService;

    public DriverRestController(DriverServiceImpl driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/driver")
    public List<Driver> showAllEntity(){
        return driverService.getAllEntity();
    }

    @GetMapping("/driver/search")
    public Driver showEntity(@RequestParam("id") int id) {
        return driverService.getEntity(id);
    }

    @PostMapping("/driver")
    public Driver saveEntity(@RequestBody Driver driver){
        return driverService.saveEntity(driver);
    }
    @PutMapping("/driver")
    public Driver updateEntity(@RequestBody Driver driver){
        return driverService.saveEntity(driver);
    }

    @DeleteMapping("/driver")
    public HandlingData deleteEntity(@RequestParam("id") int id){
        driverService.deleteEntity(id);
        return new HandlingData("Водитель с id - " + id + " удалён.");
    }
}
