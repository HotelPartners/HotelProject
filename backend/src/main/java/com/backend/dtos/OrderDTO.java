package com.backend.dtos;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.backend.pojos.enums.PaymentType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Component
public class OrderDTO {
    private Long orderId;
    private LocalDateTime orderTime;
    private PaymentType paymentMenthod;
}
