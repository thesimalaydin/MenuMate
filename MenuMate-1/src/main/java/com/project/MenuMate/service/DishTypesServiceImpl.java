package com.project.MenuMate.service;

import com.project.MenuMate.dao.DishRepository;
import com.project.MenuMate.dao.DishTypesRepository;
import com.project.MenuMate.entities.DishTypes;
import com.project.MenuMate.entities.Dishes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DishTypesServiceImpl implements DishTypesService{
    private DishTypesRepository dishTypesRepository;

    @Autowired
    public DishTypesServiceImpl(DishTypesRepository theDishTypesRepository) {
        this.dishTypesRepository = theDishTypesRepository;
    }

    @Override
    public List<DishTypes> findAll() {
        return dishTypesRepository.findAll();
    }

    @Override
    public DishTypes findById(int theId) {
        Optional<DishTypes> result = dishTypesRepository.findById(theId);

        DishTypes theDishTypes = null;
        if (result.isPresent()){
            theDishTypes = result.get();
        }else{
            throw new RuntimeException("Did not find dish id - " + theId);
        }
        return theDishTypes;
    }


    @Override
    public DishTypes save(DishTypes theDishType) {
        return dishTypesRepository.save(theDishType);
    }

    @Override
    public void deleteById(int theId) {
        dishTypesRepository.deleteById(theId);
    }
}
