package com.backend.converters.interfaces;

import java.util.List;


import com.backend.dtos.OrderDto;
import com.backend.pojos.OrderPOJO;


public interface IOrderConverter {
    public OrderPOJO dtoToPojo(OrderDto orderDTO);

    public List<OrderPOJO> dtoToPojo(List<OrderDto> orderDTOs);

    public OrderDto pojoToDto(OrderPOJO orderPOJO);

    public List<OrderDto> pojoToDto(List<OrderPOJO> orderPOJOs);
}
