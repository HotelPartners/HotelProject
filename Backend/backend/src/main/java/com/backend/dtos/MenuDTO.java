package com.backend.dtos;

import java.util.Set;

import org.springframework.stereotype.Component;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component  
@NoArgsConstructor
public class MenuDTO {
    private Long itemId;
    private String itemName;
    private double price;
    private String mealchoice;
    private String itemImage;
    // private byte[] itemImage;
  
}