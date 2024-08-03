package com.alex.warehouse.controller;

import com.alex.warehouse.dto.RequestDTO;
import com.alex.warehouse.entity.Blank;
import com.alex.warehouse.entity.Request;
import com.alex.warehouse.exception_handling.HandlingData;
import com.alex.warehouse.mapping.RequestMap;
import com.alex.warehouse.service.impl.RequestServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestRestController {
    private RequestServiceImpl baseService;

    public RequestRestController(RequestServiceImpl baseService) {
        this.baseService = baseService;
    }

    @GetMapping("/request")
    public List<Request> showAllEntity() {
        return baseService.getAllEntity();
    }

    @GetMapping("/request/search")
    public Request showEntity(@RequestParam("id") int id) {
        return baseService.getEntity(id);
    }

    @PostMapping("/request")
    public Request saveEntity(@RequestBody RequestDTO requestDTO) {
        Request request = RequestMap.mapping(requestDTO);
        return baseService.saveEntity(request);
    }

    @PutMapping("/request")
    public Request updateEntity(@RequestBody RequestDTO requestDTO) {
        return baseService.updateEntity(requestDTO);
    }

    @PutMapping("/request-to-blank")
    public Blank requestToBlank(@RequestBody RequestDTO requestDTO) {
        return baseService.requestToBlank(requestDTO);
    }

    @DeleteMapping("/request")
    public HandlingData delete(@RequestParam("id") int id) {
        baseService.deleteEntity(id);
        return new HandlingData("Заявка с id - " + id + " удалена.");
    }
}

