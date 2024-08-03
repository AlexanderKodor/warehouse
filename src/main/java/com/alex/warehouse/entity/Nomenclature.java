package com.alex.warehouse.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nomenclature")
public class Nomenclature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nomenclature_id")
    private int nomenclature_id;
    @Column(name = "nomenclature_name")
    private String name;
    @Column(name = "nomenclature_unit")
    private String unit;
    @Column(name = "nomenclature_unit_reduce")
    private String unitReduce;

    public Nomenclature() {
    }

    public Nomenclature(int nomenclature_id) {
        this.nomenclature_id = nomenclature_id;
    }

    public Nomenclature(String name, String unit, String unitReduce) {
        this.name = name;
        this.unit = unit;
        this.unitReduce = unitReduce;
    }

    public int getNomenclature_id() {
        return nomenclature_id;
    }

    public void setNomenclature_id(int nomenclature_id) {
        this.nomenclature_id = nomenclature_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitReduce() {
        return unitReduce;
    }

    public void setUnitReduce(String unitReduce) {
        this.unitReduce = unitReduce;
    }

    @Override
    public String toString() {
        return "Nomenclature{" +
                "nomenclature_id=" + nomenclature_id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", unitReduce='" + unitReduce + '\'' +
                '}';
    }
}
