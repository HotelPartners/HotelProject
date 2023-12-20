package com.backend.dtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.backend.pojos.enums.CategoryType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@ToString
@Setter
@NoArgsConstructor
public class IngredientsAndMenuByCategoryDTO {
    Set<String> ingredientNames = new HashSet<>();
    private String itemName;
    private CategoryType categoryType;
    private double itemPrice;
    
    
}
