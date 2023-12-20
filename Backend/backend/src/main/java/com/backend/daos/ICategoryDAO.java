package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.CategoryPOJO;
import com.backend.pojos.enums.CategoryType;

public interface ICategoryDAO extends JpaRepository<CategoryPOJO, Long>{

    CategoryPOJO findByCategoryName(CategoryType categoryName);

    
}
