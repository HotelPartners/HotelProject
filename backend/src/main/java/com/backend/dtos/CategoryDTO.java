package com.backend.dtos;

import org.springframework.stereotype.Component;

import com.backend.pojos.enums.CategoryType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {
    private CategoryType categoryName;
}
