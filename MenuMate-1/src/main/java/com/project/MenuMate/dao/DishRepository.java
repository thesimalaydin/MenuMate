package com.project.MenuMate.dao;

import com.project.MenuMate.entities.Dishes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dishes, Integer> {
    //entity type, primary key
}
