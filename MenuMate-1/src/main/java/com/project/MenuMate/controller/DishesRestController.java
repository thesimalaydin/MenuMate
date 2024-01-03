package com.project.MenuMate.controller;


import com.project.MenuMate.entities.Dishes;
import com.project.MenuMate.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DishesRestController {
    private DishesService dishesService;

    @Autowired
    public DishesRestController(DishesService dishesService) {
        this.dishesService = dishesService;
    }

    @GetMapping("/dishes")
    public List<Dishes> findAll() {
        return dishesService.findAll();
    }

    @GetMapping("/dishes/{dishId}")
    public Dishes getDish (@PathVariable int dishId){
        Dishes theDish = dishesService.findById(dishId);

        if(theDish == null){
            throw new RuntimeException("Dish id not found - " + dishId);
        }

        return theDish;
    }

    @PostMapping("/dishes")
    public Dishes addDish (@RequestBody Dishes theDish) {
        theDish.setId(0);

        Dishes dbDish = dishesService.save(theDish);

        return dbDish;
    }

    @PutMapping("/dishes")
    public Dishes updateDish(@RequestBody Dishes theDish){
        Dishes dbDish = dishesService.save(theDish);

        return dbDish;
    }

    @DeleteMapping("/dishes/{dishId}")
    public String deleteDish(@PathVariable int dishId){
        Dishes tempDishes = dishesService.findById(dishId);

        if(tempDishes == null){
            throw new RuntimeException("Dish id not found - " + dishId);
        }

        dishesService.deleteById(dishId);
        return "Deleted dish id - " + dishId;
    }
}
