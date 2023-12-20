package com.backend.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.dtos.MenuDTO;
import com.backend.dtos.MenuWithImageDTO;
import com.backend.pojos.enums.CategoryType;
import com.backend.services.ImageService;
import com.backend.services.interfaces.IMenuService;

@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = "*")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private ImageService imageService;


    @PostMapping("/additem/{categoryName}")
    public MenuDTO addItem(@RequestBody MenuDTO menuDTO, @PathVariable CategoryType categoryName) {
        return menuService.addItem(menuDTO, categoryName);
    }

    @GetMapping("/{categoryName}")
    public List<MenuWithImageDTO> getItems(@PathVariable String categoryName) throws FileNotFoundException, IOException{
        return menuService.getItems(CategoryType.valueOf(categoryName));
    }

    @PostMapping(value="/{itemId}/image",consumes="multipart/form-data")
    public String uploadImageToServerFolder(@RequestParam MultipartFile imageFile,@PathVariable Long itemId) throws IOException
    {
        System.out.println(imageFile+" "+itemId+"------------------------------------");
        return imageService.uploadImage(itemId, imageFile);
    }
    @DeleteMapping("/deletemenu/{itemId}")
    public String deleteMenu(@PathVariable Long itemId)
    {
    	return menuService.deleteMenu(itemId);
    }
}