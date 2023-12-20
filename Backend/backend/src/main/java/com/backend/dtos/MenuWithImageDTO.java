package com.backend.dtos;

import org.springframework.stereotype.Component;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component  
@NoArgsConstructor
public class MenuWithImageDTO {
    private Long itemId;
    private String itemName;
    private String mealchoice;
    private double price;
    private byte[] itemImage;
    
}
