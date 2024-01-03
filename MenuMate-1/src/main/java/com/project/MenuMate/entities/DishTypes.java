package com.project.MenuMate.entities;

import jakarta.persistence.*;

@Entity
@Table(name="dishtypes")
public class DishTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="types")
    String types;

    public DishTypes(String types) {
        this.types = types;
    }

    public DishTypes(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "DishTypes{" +
                "id=" + id +
                ", types=" + types +
                '}';
    }
}
