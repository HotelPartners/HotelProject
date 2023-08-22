package com.backend.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.MenuDTO;
import com.backend.services.interfaces.IMenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @PostMapping
    public MenuDTO addItem(@RequestBody MenuDTO menuDTO, @RequestBody Set<Long> ingredientIds, @PathVariable Long categoryId) {
        return menuService.addItem(menuDTO, ingredientIds, categoryId);
    }

}