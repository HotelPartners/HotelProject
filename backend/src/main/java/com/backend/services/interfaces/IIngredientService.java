package com.backend.services.interfaces;

import com.backend.dtos.IngredientDTO;

public interface IIngredientService {
    IngredientDTO addIngredient(IngredientDTO ingredientDTO, Long supplierId);
}
