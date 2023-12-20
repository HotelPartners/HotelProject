package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.IIngredientConverter;
import com.backend.dtos.IngredientDTO;
import com.backend.pojos.IngredientPOJO;

@Component
public class IngredientConverter implements IIngredientConverter{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public IngredientPOJO dtoToPojo(IngredientDTO ingredientDTO) {
        return modelMapper.map(ingredientDTO, IngredientPOJO.class);
    }

    @Override
    public List<IngredientPOJO> dtoToPojo(List<IngredientDTO> ingredientDTOs) {
        return ingredientDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public IngredientDTO pojoToDto(IngredientPOJO ingredientPOJO) {
        return modelMapper.map(ingredientPOJO, IngredientDTO.class);
    }

    @Override
    public List<IngredientDTO> pojoToDto(List<IngredientPOJO> ingredientPOJOs) {
        return ingredientPOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
}
