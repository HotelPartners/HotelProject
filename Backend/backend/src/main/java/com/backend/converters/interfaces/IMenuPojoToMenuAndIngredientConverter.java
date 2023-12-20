package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.IngredientsAndMenuByCategoryDTO;
import com.backend.pojos.MenuPOJO;
import com.backend.pojos.enums.CategoryType;

public interface IMenuPojoToMenuAndIngredientConverter {
    // public MenuPOJO dtoToPojo(IngredientsAndMenuByCategoryDTO ingredientsAndMenuByCategoryDTO);

    // public List<MenuPOJO> dtoToPojo(List<IngredientsAndMenuByCategoryDTO> ingredientsAndMenuByCategoryDTOs);

    public IngredientsAndMenuByCategoryDTO pojoToDto(MenuPOJO menuPOJO, CategoryType categoryName);

    // public List<IngredientsAndMenuByCategoryDTO> pojoToDto(List<MenuPOJO> menuPOJOs);
}
