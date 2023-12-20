package com.backend.dtos;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Component
public class OrderItemsDTO {
//    private Long orderId;
//    private LocalDateTime orderTime;
//    private PaymentType paymentMenthod;
//    List<Long> itemIds;
    private Long itemId;
    private String itemName;
    private Integer quantity;
    private String mealchoice;
    private Long price;
 
}
