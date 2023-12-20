package com.backend.services.interfaces;

import java.util.List;

import com.backend.dtos.IngredientDTO;
import com.backend.dtos.IngredientsWithSupplierDTO;

public interface IIngredientService {
    IngredientDTO addIngredient(IngredientDTO ingredientDTO, String supplierName);
    List<IngredientsWithSupplierDTO> allIngrediens();
    String updateIngredient(IngredientDTO ingredientDTO,String supplierName, Long ingredientId);
    String deleteIngredient(Long ingredientId);
    IngredientsWithSupplierDTO editIngredient(Long ingredientId);


}
