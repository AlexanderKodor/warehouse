package com.alex.warehouse.controller;


import com.alex.warehouse.entity.Role;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Role> roleList = baseService.getAllEntity();
        if(roleList.isEmpty()){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return roleList;
    }
    @GetMapping("/role/search")
    public Role showEntity(@RequestParam("id") int id){
        Role role = baseService.getEntity(id);
        if(role==null){
            throw new NoSuchDataException("Роль с id - " + id + " отсутствует.");
        }
        return role;
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
        Role role = baseService.getEntity(id);
        if(role==null){
            throw new NoSuchDataException("Роль с id - " + id + " отсутствует.");
        }
        baseService.deleteEntity(id);
        return new HandlingData("Роль с id - " + id + " удалена.");
    }
}

