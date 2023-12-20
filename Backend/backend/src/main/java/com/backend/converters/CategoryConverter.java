package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.ICategoryConverter;
import com.backend.dtos.CategoryDTO;
import com.backend.pojos.CategoryPOJO;

@Component
public class CategoryConverter implements ICategoryConverter{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryPOJO dtoToPojo(CategoryDTO categoryDTO) {
        return modelMapper.map(categoryDTO, CategoryPOJO.class);
    }

    @Override
    public List<CategoryPOJO> dtoToPojo(List<CategoryDTO> categoryDTOs) {
        return categoryDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO pojoToDto(CategoryPOJO categoryPOJO) {
        return modelMapper.map(categoryPOJO, CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> pojoToDto(List<CategoryPOJO> categoryPOJOs) {
        return categoryPOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
    
}
