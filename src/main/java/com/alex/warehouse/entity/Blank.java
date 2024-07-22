package com.alex.warehouse.entity;

import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "blanks")
@Builder
public class Blank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blank_id")
    private int id;
    @OneToOne
    @JoinColumn(name = "request_id")
    private Request request;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @ManyToOne
    @JoinColumn(name = "tanker_id")
    private Tanker tanker;
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

    public Blank() {
    }

    public Blank(int id) {
        this.id = id;
    }

    public Blank(int id, Request request, Driver driver, Tanker tanker, Status status, Employee employee, LocalDateTime dateCreate, LocalDateTime dateChange) {
        this.id = id;
        this.request = request;
        this.driver = driver;
        this.tanker = tanker;
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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Tanker getTanker() {
        return tanker;
    }

    public void setTanker(Tanker tanker) {
        this.tanker = tanker;
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
        return "Blank{" +
                "id=" + id +
                ", request=" + request +
                ", driver=" + driver +
                ", tanker=" + tanker +
                ", status=" + status +
                ", employee=" + employee +
                ", dateCreate=" + dateCreate +
                ", dateChange=" + dateChange +
                '}';
    }
}
