package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.MenuDTO;
import com.backend.pojos.MenuPOJO;

public interface IMenuConverter {
    
    public MenuPOJO dtoToPojo(MenuDTO menuDto);
   

    public List<MenuPOJO> dtoToPojo(List<MenuDTO> menuDto);

    public MenuDTO pojoToDto(MenuPOJO menuPojo);

    public List<MenuDTO> pojoToDto(List<MenuPOJO> menuPojo);
}