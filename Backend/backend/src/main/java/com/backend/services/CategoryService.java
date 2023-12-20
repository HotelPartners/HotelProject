package com.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.ICategoryConverter;
import com.backend.daos.ICategoryDAO;
import com.backend.dtos.CategoryDTO;
import com.backend.services.interfaces.ICategoryService;

@Service
@Transactional
public class CategoryService implements ICategoryService{

    @Autowired
    private ICategoryDAO categoryDAO;
    @Autowired
    private ICategoryConverter categoryConverter;

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        return categoryConverter.pojoToDto(categoryDAO.save(categoryConverter.dtoToPojo(categoryDTO)));
    }

    @Override
    public List<CategoryDTO> showAllCategories() {
        return categoryConverter.pojoToDto(categoryDAO.findAll());
    }
    
}
