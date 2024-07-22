package com.alex.warehouse.controller;

import com.alex.warehouse.dto.BlankDTO;
import com.alex.warehouse.entity.Blank;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.exception_handling.NoSuchDataException;
import com.alex.warehouse.mapping.BlankMap;
import com.alex.warehouse.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
            throw new NoSuchDataException("Котировка с id - " + id + " отсутствует.");
        }
        return blank;
    }

    @PostMapping("/blank")
    public Blank saveEntity(@RequestBody BlankDTO blankDTO){
        Blank blank = BlankMap.mapping(blankDTO);
        if(blank.getId()!=0){
            throw new NoSuchDataException("Методом POST нет возможности передачи id");
        }
        blank.setDateCreate(LocalDateTime.now());
        blank.setDateChange(LocalDateTime.now());

        return baseService.saveEntity(blank);
    }

    @PutMapping("/blank")
    public Blank updateEntity(@RequestBody BlankDTO blankDTO){
        if(blankDTO.getId()==0){
            throw new NoSuchDataException("Во входящих данных отсутствует id.");
        }
        Blank blankOld = baseService.getEntity(blankDTO.getId());
        if (blankOld == null) {
            throw new NoSuchDataException("Котировка с id - " + blankDTO.getId() + " отсутствует.");
        }
        Blank blank = BlankMap.mapping(blankDTO);
        blank.setDateCreate(blankOld.getDateCreate());
        blank.setDateChange(LocalDateTime.now());
        return baseService.saveEntity(blank);
    }

//    @PostMapping("/blank")
//    public Blank saveEntity(@RequestBody Blank blank){
//        return baseService.saveEntity(blank);
//    }
//
//    @PutMapping("/blank")
//    public Blank updateEntity(@RequestBody Blank blank){
//        return baseService.saveEntity(blank);
//    }

    @DeleteMapping("/blank")
    public HandlingData delete(@RequestParam("id") int id){
        Blank blank = baseService.getEntity(id);
        if(blank==null){
            throw new NoSuchDataException("Котировка с id - " + id + " отсутствует.");
        }
        baseService.deleteEntity(id);
        return new HandlingData("Котировка с id - " + id + " удалена.");
    }
}
