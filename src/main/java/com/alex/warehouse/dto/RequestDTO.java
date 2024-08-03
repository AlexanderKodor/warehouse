package com.alex.warehouse.dto;

import lombok.Data;

@Data
public class RequestDTO {
    private int id;
    private int number;
    private int nomenclature_id;
    private int quantity;
    private int company_id;
    private int status_id;
    private int employee_id;
}
