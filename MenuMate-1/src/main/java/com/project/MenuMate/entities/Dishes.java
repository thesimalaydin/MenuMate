package com.project.MenuMate.entities;

import jakarta.persistence.*;

@Entity
@Table(name="dishes")
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="dishnames")
    String dishNames;

    @Column(name="typeid")
    int typeId;

    @Column(name="price")
    float price;

    public Dishes(String dishNames, int typeId, float price) {
        this.dishNames = dishNames;
        this.typeId = typeId;
        this.price = price;
    }

    public Dishes(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishNames() {
        return dishNames;
    }

    public void setDishNames(String dishNames) {
        this.dishNames = dishNames;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "id=" + id +
                ", dishNames=" + dishNames +
                ", typeId=" + typeId +
                ", price=" + price +
                '}';
    }
}
