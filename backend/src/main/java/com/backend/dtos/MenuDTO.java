package com.backend.dtos;

import org.springframework.stereotype.Component;

import com.backend.pojos.enums.VegorNonType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component  
@NoArgsConstructor
public class MenuDTO {
    private Long userid;
    private String itemName;
    private double price;
    private VegorNonType category ;
    private byte [] itemImage;
    private String ingredients;
}