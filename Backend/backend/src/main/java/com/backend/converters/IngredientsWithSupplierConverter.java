package com.backend.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.IIngredientsWithSupplierConverter;

import com.backend.dtos.IngredientsWithSupplierDTO;
import com.backend.pojos.IngredientPOJO;

@Component
public class IngredientsWithSupplierConverter implements IIngredientsWithSupplierConverter {

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public IngredientsWithSupplierDTO pojoToDto(IngredientPOJO ingredientPOJO) {
       return modelMapper.map(ingredientPOJO, IngredientsWithSupplierDTO.class);

    }
    
}
