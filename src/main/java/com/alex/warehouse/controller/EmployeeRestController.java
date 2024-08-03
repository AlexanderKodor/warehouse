package com.alex.warehouse.controller;

import com.alex.warehouse.entity.Employee;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    BaseService<Employee> baseService;

    public EmployeeRestController(BaseService<Employee> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/employee")
    public List<Employee> showAllEntity(){
        return baseService.getAllEntity();
    }

    @GetMapping("/employee/search")
    public Employee showEntity(@RequestParam("id") int id){
        return baseService.getEntity(id);
    }

    @PostMapping("/employee")
    public Employee saveEntity(@RequestBody Employee employee){
        return baseService.saveEntity(employee);
    }

    @PutMapping("/employee")
    public Employee updateEntity(@RequestBody Employee employee){
        return baseService.saveEntity(employee);
    }

    @DeleteMapping("/employee")
    public HandlingData deleteEntity(@RequestParam("id") int id){
        baseService.deleteEntity(id);
        return new HandlingData("Работник с id - " + id + " удалён.");
    }

}
