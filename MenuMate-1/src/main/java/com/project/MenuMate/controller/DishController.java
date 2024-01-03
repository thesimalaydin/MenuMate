package com.project.MenuMate.controller;

import com.project.MenuMate.entities.Dishes;
import com.project.MenuMate.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/dishes")
public class DishController {
    private DishesService dishesService;

    @Autowired
    public DishController(DishesService theDishesService){
        dishesService = theDishesService;
    }

    @GetMapping("list")
    public String listDishes(Model theModel){
        // get the dishes from db
        List<Dishes> theDishes = dishesService.findAll();
        //add to the spring model
        theModel.addAttribute("dishes", theDishes);

        return "list-dishes";
    }
}
