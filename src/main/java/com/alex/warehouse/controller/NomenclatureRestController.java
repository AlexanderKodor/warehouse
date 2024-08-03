package com.alex.warehouse.controller;

import com.alex.warehouse.entity.Driver;
import com.alex.warehouse.entity.Nomenclature;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class NomenclatureRestController {
    private BaseService<Nomenclature> baseService;

    public NomenclatureRestController(BaseService<Nomenclature> baseService) {
        this.baseService = baseService;
    }
    @GetMapping("/nomenclature")
    public List<Nomenclature> showAllEntity(){
        return baseService.getAllEntity();
    }
    @GetMapping("/nomenclature/search")
    public Nomenclature showEntity(@RequestParam("id") int id) {
        return baseService.getEntity(id);
    }

    @PostMapping("/nomenclature")
    public Nomenclature saveEntity(@RequestBody Nomenclature nomenclature){
        return baseService.saveEntity(nomenclature);
    }
    @PutMapping("/nomenclature")
    public Nomenclature updateEntity(@RequestBody Nomenclature nomenclature){
        return baseService.saveEntity(nomenclature);
    }

    @DeleteMapping("/nomenclature")
    public HandlingData deleteEntity(@RequestParam("id") int id){
        baseService.deleteEntity(id);
        return new HandlingData("Номенклатура с id - " + id + " удалёна.");
    }
}
