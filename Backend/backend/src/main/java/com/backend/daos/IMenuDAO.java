package com.backend.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.CategoryPOJO;
import com.backend.pojos.MenuPOJO;
import com.backend.pojos.enums.CategoryType;

public interface IMenuDAO extends JpaRepository<MenuPOJO, Long> {

    List<MenuPOJO> findByCategory(CategoryPOJO findByCategoryName);
    
}