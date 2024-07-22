package com.alex.warehouse.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InvoiceDTO {
    private int id;
    private int blank_id;
    private String number;
    private int nomenclature_id;
    private int quantity;
    private int company_id;
    private int employee_id;
    private LocalDateTime dateInvoice;
    private int status_id;
}
