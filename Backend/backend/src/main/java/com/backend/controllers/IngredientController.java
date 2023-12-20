package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.IngredientDTO;
import com.backend.dtos.IngredientsWithSupplierDTO;
import com.backend.services.interfaces.IIngredientService;

@RestController
@RequestMapping("/ingredients")
@CrossOrigin(origins = "*")
public class IngredientController {
    @Autowired
    private IIngredientService ingredientService;

    @PostMapping("/add-ingredients/{supplierName}")
    public IngredientDTO addIngredient(@RequestBody IngredientDTO ingredientDTO, @PathVariable String supplierName){
        return ingredientService.addIngredient(ingredientDTO, supplierName);
    }

    @GetMapping("/all-ingredients")
    public List<IngredientsWithSupplierDTO>allIngredients()
    {
        return ingredientService.allIngrediens();
    }

    @PutMapping("/update-ingredients/{supplierName}/{ingredientId}")
    public String updateIngredients(@RequestBody IngredientDTO ingredientDTO,@PathVariable String supplierName,@PathVariable Long ingredientId)
    {
        return ingredientService.updateIngredient(ingredientDTO, supplierName, ingredientId);
    }


    @DeleteMapping("/delete-ingredients/{ingredientId}")
    public String deleteIngredients(@PathVariable Long ingredientId)
    {
        return ingredientService.deleteIngredient(ingredientId);
    }

    @GetMapping("/edit-ingredient/{ingredientId}")
    public IngredientsWithSupplierDTO editIngredient(@PathVariable Long ingredientId)
    {
        return ingredientService.editIngredient(ingredientId);
    }

}
