package com.alex.warehouse.mapping;

import com.alex.warehouse.dto.BlankDTO;
import com.alex.warehouse.entity.*;

public class BlankMap {
    public static Blank mapping(BlankDTO dto){
        return Blank.builder()
                .id(dto.getId())
                .request(new Request(dto.getRequest_id()))
                .driver(new Driver(dto.getDriver_id()))
                .tanker(new Tanker(dto.getTanker_id()))
                .status(new Status(dto.getStatus_id()))
                .employee(new Employee(dto.getEmployee_id()))
                .build();
    }
}
