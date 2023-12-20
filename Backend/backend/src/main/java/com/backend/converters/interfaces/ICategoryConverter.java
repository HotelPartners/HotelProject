package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.CategoryDTO;
import com.backend.pojos.CategoryPOJO;

public interface ICategoryConverter {
    public CategoryPOJO dtoToPojo(CategoryDTO categoryDTO);

    public List<CategoryPOJO> dtoToPojo(List<CategoryDTO> categoryDTOs);

    public CategoryDTO pojoToDto(CategoryPOJO categoryPOJO);

    public List<CategoryDTO> pojoToDto(List<CategoryPOJO> categoryPOJOs);
}
