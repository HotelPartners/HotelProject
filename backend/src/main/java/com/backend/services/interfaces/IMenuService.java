package com.backend.services.interfaces;

import java.util.List;

import com.backend.dtos.MenuDTO;
import com.backend.pojos.MenuPOJO;


public interface IMenuService {

    public MenuPOJO addMenu(MenuDTO menuDto);
    public List<MenuDTO> allMenu();
}