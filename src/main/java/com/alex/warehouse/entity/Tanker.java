package com.alex.warehouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tankers")
public class Tanker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tanker_id")
    private int id;
    @Column(name = "tanker_number")
    private String number;
    @Column(name = "certificate")
    private String certificate;

    public Tanker() {
    }

    public Tanker(String number, String certificate) {
        this.number = number;
        this.certificate = certificate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Tanker{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", certificate='" + certificate + '\'' +
                '}';
    }
}
