package com.alex.warehouse.controller;

import com.alex.warehouse.entity.Employee;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Employee> employeeList = baseService.getAllEntity();
        if(employeeList.size()==0){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return employeeList;
    }

    @GetMapping("/employee/search")
    public Employee showEntity(@RequestParam("id") int id){
        Employee employee = baseService.getEntity(id);
        if(employee==null){
            throw new NoSuchDataException("Работник с id - " + id + " отсутствует.");
        }
        return employee;
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
        Employee employee = baseService.getEntity(id);
        if(employee==null){
            throw new NoSuchDataException("Работник с id - " + id + " отсутствует.");
        }
        baseService.deleteEntity(id);
        return new HandlingData("Работник с id - " + id + " удалён.");
    }

}
