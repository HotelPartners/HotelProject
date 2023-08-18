package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.MenuDTO;
import com.backend.pojos.MenuPOJO;
import com.backend.services.MenuService;




@RestController
@RequestMapping("/menu_controller")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/add-menu")
    public MenuPOJO addMenu(@RequestBody MenuDTO menu){
        return menuService.addMenu(menu);
    }

    @GetMapping("/allmenu")
    public List<MenuDTO> AllMenu(){
    return menuService.allMenu();
    }

}