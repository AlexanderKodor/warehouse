package com.alex.warehouse.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
@Table(name = "requests")
@Builder
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private int id;
    @Column(name = "number_request")
    private int number;
    @ManyToOne
    @JoinColumn(name = "nomenclature_id")
    private Nomenclature nomenclature;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "date_create")
    private LocalDateTime dateCreate;
    @Column(name = "date_change")
    private LocalDateTime dateChange;

    public Request() {
    }

    public Request(int id) {
        this.id = id;
    }

    public Request(int id, int number, Nomenclature nomenclature, int quantity, Company company, Status status, Employee employee, LocalDateTime dateCreate, LocalDateTime dateChange) {
        this.id = id;
        this.number = number;
        this.nomenclature = nomenclature;
        this.quantity = quantity;
        this.company = company;
        this.status = status;
        this.employee = employee;
        this.dateCreate = dateCreate;
        this.dateChange = dateChange;
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

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateChange() {
        return dateChange;
    }

    public void setDateChange(LocalDateTime dateChange) {
        this.dateChange = dateChange;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", number=" + number +
                ", nomenclature=" + nomenclature +
                ", quantity=" + quantity +
                ", company=" + company +
                ", status=" + status +
                ", employee=" + employee +
                ", dateCreate=" + dateCreate +
                ", dateChange=" + dateChange +
                '}';
    }
}
