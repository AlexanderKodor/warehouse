package com.alex.warehouse.dto;


public class RequestDTO {
    private int id;
    private int number;
    private int nomenclature_id;
    private int quantity;
    private int company_id;
    private int status_id;
    private int employee_id;

    public RequestDTO() {
    }

    public RequestDTO(int number, int nomenclature_id, int quantity, int company_id, int status_id, int employee_id) {
        this.number = number;
        this.nomenclature_id = nomenclature_id;
        this.quantity = quantity;
        this.company_id = company_id;
        this.status_id = status_id;
        this.employee_id = employee_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNomenclature_id() {
        return nomenclature_id;
    }

    public void setNomenclature_id(int nomenclature_id) {
        this.nomenclature_id = nomenclature_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }
}
