package com.alex.warehouse.controller;


import com.alex.warehouse.entity.Role;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleRestController {
    private BaseService<Role> baseService;

    public RoleRestController(BaseService<Role> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/role")
    public List<Role> showAllEntity(){
        return baseService.getAllEntity();
    }
    @GetMapping("/role/search")
    public Role showEntity(@RequestParam("id") int id){
        return baseService.getEntity(id);
    }

    @PostMapping("/role")
    public Role saveEntity(@RequestBody Role role){
        return baseService.saveEntity(role);
    }

    @PutMapping("/role")
    public Role updateEntity(@RequestBody Role role){
        return baseService.saveEntity(role);
    }

    @DeleteMapping("/role")
    public HandlingData delete(@RequestParam("id") int id){
        baseService.deleteEntity(id);
        return new HandlingData("Роль с id - " + id + " удалена.");
    }
}

