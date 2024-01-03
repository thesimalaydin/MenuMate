package com.project.MenuMate.service;

import com.project.MenuMate.entities.DishTypes;

import java.util.List;

public interface DishTypesService {
    List<DishTypes> findAll();

    DishTypes findById(int theId);

    DishTypes save(DishTypes theDishType);

    void deleteById(int theId);
}
