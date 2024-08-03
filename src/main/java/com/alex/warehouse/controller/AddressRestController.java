package com.alex.warehouse.controller;

import com.alex.warehouse.entity.Address;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressRestController {
    private BaseService<Address> baseService;

    public AddressRestController(BaseService<Address> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/address")
    public List<Address> showAllEntity() {
        return baseService.getAllEntity();
    }

    @GetMapping("/address/search")
    public Address findEntity(@RequestParam("id") int id) {
        return baseService.getEntity(id);
    }

    @PostMapping("/address")
    public Address saveEntity(@RequestBody Address address) {
        return baseService.saveEntity(address);
    }

    @PutMapping("/address")
    public Address updateEntity(@RequestBody Address address) {
        return baseService.saveEntity(address);
    }

    @DeleteMapping("/address")
    public HandlingData deleteEntity(@RequestParam("id") int id) {
        baseService.deleteEntity(id);
        return new HandlingData("Адрес с id - " + id + " удалён.");
    }

}
