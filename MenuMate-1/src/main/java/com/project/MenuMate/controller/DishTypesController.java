package com.project.MenuMate.controller;

import com.project.MenuMate.entities.DishTypes;

import com.project.MenuMate.service.DishTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class DishTypesController {
    private DishTypesService dishTypesService;

    @Autowired
    public DishTypesController(DishTypesService theDishTypesService) {
        this.dishTypesService = theDishTypesService;
    }

    @GetMapping("/dishTypes")
    public List<DishTypes> findAll() {
        return dishTypesService.findAll();
    }

    @GetMapping("/dishTypes/{dishTypeId}")
    public DishTypes getDishType (@PathVariable int dishTypeId){
        DishTypes theDishType = dishTypesService.findById(dishTypeId);

        if(theDishType == null){
            throw new RuntimeException("Dish id not found - " + dishTypeId);
        }

        return theDishType;
    }

    @PostMapping("/dishTypes")
    public DishTypes addDishType (@RequestBody DishTypes theDishType) {
        theDishType.setId(0);

        DishTypes dbDishType = dishTypesService.save(theDishType);

        return dbDishType;
    }

    @PutMapping("/dishTypes")
    public DishTypes updateDishType(@RequestBody DishTypes theDishType){
        DishTypes dbDish = dishTypesService.save(theDishType);

        return dbDish;
    }

    @DeleteMapping("/dishTypes/{dishTypeId}")
    public String deleteDishType(@PathVariable int dishTypeId){
        DishTypes tempDishType = dishTypesService.findById(dishTypeId);

        if(tempDishType == null){
            throw new RuntimeException("Dish id not found - " + dishTypeId);
        }

        dishTypesService.deleteById(dishTypeId);
        return "Deleted dish id - " + dishTypeId;
    }
}
