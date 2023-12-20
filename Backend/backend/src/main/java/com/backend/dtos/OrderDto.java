package com.backend.dtos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.backend.pojos.enums.OrderStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
public class OrderDto {

	private Long userId;
	private Long orderId;
	private Long addressId;
	private String paymentType;
	private Long totalqty;
	private Long totalprice;
	List<OrderItemsDTO> itemsDTOs;
	private AddressDTO addressDto;
	   private LocalDateTime date;
	   private String orderstatus;
	   
	  
}
