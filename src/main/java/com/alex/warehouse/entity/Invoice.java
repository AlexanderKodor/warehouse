package com.alex.warehouse.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private int id;
    @OneToOne
    @JoinColumn(name = "blank_id")
    private Blank blank;
    @Column(name = "invoice_number")
    private String number;
    @ManyToOne
    @JoinColumn(name = "nomenclature_id")
    private Nomenclature nomenclature;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "date_invoice")
    private LocalDateTime dateInvoice;
    @Column(name = "date_create")
    private LocalDateTime dateCreate;
    @Column(name = "date_change")
    private LocalDateTime dateChange;

    public Invoice() {
    }

    public Invoice(Blank blank, String number, Nomenclature nomenclature, int quantity, Company company
            , Employee employee, LocalDateTime dateInvoice, LocalDateTime dateCreate, LocalDateTime dateChange) {
        this.blank = blank;
        this.number = number;
        this.nomenclature = nomenclature;
        this.quantity = quantity;
        this.company = company;
        this.employee = employee;
        this.dateInvoice = dateInvoice;
        this.dateCreate = dateCreate;
        this.dateChange = dateChange;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blank getBlank() {
        return blank;
    }

    public void setBlank(Blank blank) {
        this.blank = blank;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(LocalDateTime dateInvoice) {
        this.dateInvoice = dateInvoice;
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
        return "Invoice{" +
                "id=" + id +
                ", blank=" + blank +
                ", number='" + number + '\'' +
                ", nomenclature=" + nomenclature +
                ", quantity=" + quantity +
                ", company=" + company +
                ", employee=" + employee +
                ", dateInvoice=" + dateInvoice +
                ", dateCreate=" + dateCreate +
                ", dateChange=" + dateChange +
                '}';
    }
}
