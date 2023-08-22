package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.IngredientDTO;
import com.backend.services.interfaces.IIngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    private IIngredientService ingredientService;

    @PostMapping("/add-ingredients")
    public ResponseEntity<?> addIngredient(@RequestBody IngredientDTO ingredientDTO, @PathVariable Long supplierId){
        return ResponseEntity.status(HttpStatus.OK).body(ingredientService.addIngredient(ingredientDTO, supplierId));
    }
}
