package com.backend.converters.interfaces;




import com.backend.pojos.IngredientPOJO;
import com.backend.dtos.IngredientsWithSupplierDTO;


public interface IIngredientsWithSupplierConverter {
    public IngredientsWithSupplierDTO pojoToDto(IngredientPOJO ingredientPOJO);
}
