package com.alex.warehouse.controller;

import com.alex.warehouse.entity.Driver;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverRestController {
    private DriverServiceImpl driverService;
    @Autowired
    public DriverRestController(DriverServiceImpl driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public List<Driver> showAllEntity(){
        return driverService.getAllEntity();
    }

    @GetMapping("/drivers/search")
    public Driver showEntity(@RequestParam("id") int id) {
        Driver driver = driverService.getEntity(id);
        if(driver==null){
            throw new NoSuchDataException("Водитель с id - " + id + " не найден.");
        }
        return driver;
    }

    @PostMapping("/drivers")
    public Driver saveEntity(@RequestBody Driver driver){
        return driverService.saveEntity(driver);
    }
    @PutMapping("/drivers")
    public Driver updateEntity(@RequestBody Driver driver){
        return driverService.saveEntity(driver);
    }

    @DeleteMapping("/drivers")
    public HandlingData deleteEntity(@RequestParam("id") int id){
        Driver driver = driverService.getEntity(id);
        if(driver==null){
            throw new NoSuchDataException("Водитель с id - " + id + " не найден.");
        }
        driverService.deleteEntity(id);
        return new HandlingData("Водитель с id - " + id + " удалён.");
    }
}
