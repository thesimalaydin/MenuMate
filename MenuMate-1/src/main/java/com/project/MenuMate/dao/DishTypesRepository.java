package com.project.MenuMate.dao;

import com.project.MenuMate.entities.DishTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishTypesRepository extends JpaRepository<DishTypes, Integer> {
}
