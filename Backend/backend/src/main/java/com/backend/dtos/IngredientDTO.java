package com.backend.dtos;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Component
public class IngredientDTO {
    private Long ingredientId;
    private String ingredientName;
    private Long ingredientCapacity;
    private LocalDate dateOfIngredientAdded;
    
}
