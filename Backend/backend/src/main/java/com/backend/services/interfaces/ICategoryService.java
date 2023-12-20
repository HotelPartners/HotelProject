package com.backend.services.interfaces;

import java.util.List;

import com.backend.dtos.CategoryDTO;

public interface ICategoryService {
    CategoryDTO addCategory(CategoryDTO categoryDTO);
    List<CategoryDTO> showAllCategories();
}
