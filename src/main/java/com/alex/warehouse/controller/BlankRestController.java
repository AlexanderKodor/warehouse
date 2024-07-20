package com.alex.warehouse.controller;

import com.alex.warehouse.entity.Address;
import com.alex.warehouse.entity.Blank;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.service.BaseService;
import com.alex.warehouse.service.BlankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlankRestController {
    private BaseService<Blank> baseService;

    @Autowired
    public BlankRestController(BaseService<Blank> baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/blank")
    public List<Blank> showAllEntity(){
        List<Blank> blankList = baseService.getAllEntity();
        if(blankList.size()==0){
            throw new NoSuchDataException("Информация по данному запросу отсутсвует.");
        }
        return blankList;
    }
    @GetMapping("/blank/search")
    public Blank showEntity(@RequestParam("id") int id){
        Blank blank = baseService.getEntity(id);
        if(blank==null){
            throw new NoSuchDataException("Заявка с id - " + id + " отсутствует.");
        }
        return blank;
    }

    @PostMapping("/blank")
    public Blank saveEntity(@RequestBody Blank blank){
        return baseService.saveEntity(blank);
    }

    @PutMapping("/blank")
    public Blank updateEntity(@RequestBody Blank blank){
        return baseService.saveEntity(blank);
    }

    @DeleteMapping("/blank")
    public HandlingData delete(@RequestParam("id") int id){
        Blank blank = baseService.getEntity(id);
        if(blank==null){
            throw new NoSuchDataException("Заявка с id - " + id + " отсутствует.");
        }
        baseService.deleteEntity(id);
        return new HandlingData("Заявка с id - " + id + " удалена.");
    }
}
