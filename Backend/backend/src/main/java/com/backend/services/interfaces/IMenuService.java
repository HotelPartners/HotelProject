package com.backend.services.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.backend.dtos.MenuDTO;
import com.backend.dtos.MenuWithImageDTO;
import com.backend.pojos.enums.CategoryType;


public interface IMenuService  {

    public MenuDTO addItem(MenuDTO menuDTO, CategoryType categoryName);

    public List<MenuWithImageDTO> getItems(CategoryType categoryName) throws FileNotFoundException, IOException ;

    public String deleteMenu(Long itemId);

}
