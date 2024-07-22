package com.alex.warehouse.mapping;

import com.alex.warehouse.dto.InvoiceDTO;
import com.alex.warehouse.entity.*;

public class InvoiceMap {
    public static Invoice mapping(InvoiceDTO dto){
        return Invoice.builder()
                .id(dto.getId())
                .blank(new Blank(dto.getBlank_id()))
                .number(dto.getNumber())
                .nomenclature(new Nomenclature(dto.getNomenclature_id()))
                .quantity(dto.getQuantity())
                .company(new Company(dto.getCompany_id()))
                .employee(new Employee(dto.getEmployee_id()))
                .dateInvoice(dto.getDateInvoice())
                .status(new Status(dto.getStatus_id()))
                .build();
    }
}
