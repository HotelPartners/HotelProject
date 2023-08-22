package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.IngredientDTO;
import com.backend.pojos.IngredientPOJO;

public interface IIngredientConverter {
    public IngredientPOJO dtoToPojo(IngredientDTO ingredientDTO);

    public List<IngredientPOJO> dtoToPojo(List<IngredientDTO> ingredientDTOs);

    public IngredientDTO pojoToDto(IngredientPOJO ingredientPOJO);

    public List<IngredientDTO> pojoToDto(List<IngredientPOJO> ingredientPOJOs);
}
