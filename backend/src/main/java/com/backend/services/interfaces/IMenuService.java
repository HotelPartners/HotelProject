package com.backend.services.interfaces;

import java.util.List;
import java.util.Set;

import com.backend.dtos.MenuDTO;


public interface IMenuService {

    public MenuDTO addItem(MenuDTO menuDTO, Set<Long> ingredientIds, Long categoryId);
}