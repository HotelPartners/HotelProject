package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.IngredientPOJO;


public interface IIngredientDAO extends JpaRepository<IngredientPOJO, Long>{

    
}
