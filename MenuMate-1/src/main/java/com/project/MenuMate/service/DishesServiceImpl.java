package com.project.MenuMate.service;

import com.project.MenuMate.dao.DishRepository;
import com.project.MenuMate.entities.Dishes;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishesServiceImpl implements DishesService{

    private DishRepository dishRepository;

    @Autowired
    public DishesServiceImpl(DishRepository theDishRepository) {
        this.dishRepository = theDishRepository;
    }

    @Override
    public List<Dishes> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dishes findById(int theId) {
        Optional<Dishes> result = dishRepository.findById(theId);

        Dishes theDish = null;
        if (result.isPresent()){
            theDish = result.get();
        }else{
            throw new RuntimeException("Did not find dish id - " + theId);
        }
        return theDish;
    }


    @Override
    public Dishes save(Dishes theDish) {
        return dishRepository.save(theDish);
    }

    @Override
    public void deleteById(int theId) {
        dishRepository.deleteById(theId);
    }
}
