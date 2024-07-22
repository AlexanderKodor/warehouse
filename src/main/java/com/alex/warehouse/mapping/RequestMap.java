package com.alex.warehouse.mapping;

import com.alex.warehouse.dto.RequestDTO;
import com.alex.warehouse.entity.*;

public class RequestMap {
    public static Request mapping(RequestDTO dto){
        return Request.builder()
                .id(dto.getId())
                .number(dto.getNumber())
                .nomenclature(new Nomenclature(dto.getNomenclature_id()))
                .quantity(dto.getQuantity())
                .company(new Company(dto.getCompany_id()))
                .status(new Status(dto.getStatus_id()))
                .employee(new Employee(dto.getEmployee_id()))
                .build();
    }
}
