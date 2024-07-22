package com.alex.warehouse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private int id;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "nomenclature_id")
    private Nomenclature nomenclature;
    @Column(name = "quantity")
    private int quantity;

    public Warehouse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", nomenclature=" + nomenclature +
                ", quantity=" + quantity +
                '}';
    }
}
