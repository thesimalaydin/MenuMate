package com.project.MenuMate.service;

import com.project.MenuMate.entities.Dishes;

import java.util.List;

public interface DishesService {
    List<Dishes> findAll();

    Dishes findById(int theId);

    Dishes save(Dishes theDish);

    void deleteById(int theId);
}
